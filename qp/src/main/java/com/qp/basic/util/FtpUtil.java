package com.qp.basic.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 支持断点续传的FTP实用类
 * 
 * @version 0.1 实现基本断点上传下载
 * @version 0.2 实现上传下载进度汇报
 * @version 0.3 实现中文目录创建及中文文件创建，添加对于中文的支持
 */
public class FtpUtil {
    private final static Log log = LogFactory.getLog(FTP.class);

    private static String FTP_SERVER = "";

    private static String FTP_PORT = "";

    private static String FTP_USERNAME = "";

    private static String FTP_PASSWORD = "";

    // 静态块：设置静态变量
    static {
        log.debug("FTP初始化，开始设置参数...");
        Properties prop = PropertyUtil.getConfig(SysConstants.FileSysConfig.FILESYS_CONFIG);
        // 设置用户名密码和邮件服务器
        FTP_SERVER = prop.getProperty(SysConstants.FileSysConfig.FTP_SERVER);
        FTP_PORT = prop.getProperty(SysConstants.FileSysConfig.FTP_PORT);
        FTP_USERNAME = prop.getProperty(SysConstants.FileSysConfig.FTP_USERNAME);
        FTP_PASSWORD = prop.getProperty(SysConstants.FileSysConfig.FTP_PASSWORD);
    }

    private static FtpUtil instance = null;

    private FTPClient ftpClient = null;

    private FtpUtil() {
        ftpClient = new FTPClient();
    }

    /**
     * 获取ftp客户端的实例
     * 
     * @return
     */
    public static FtpUtil getInstance() {
        if (instance == null)
            instance = new FtpUtil();
        return instance;
    }
    
    public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	/**
     * 连接到FTP服务器
     * 
     * @param hostname
     *            主机名
     * @param port
     *            端口
     * @param username
     *            用户名
     * @param password
     *            密码
     * @return 是否连接成功
     * @throws IOException
     */
    public boolean connect() throws IOException {
        ftpClient.connect(FTP_SERVER, Integer.parseInt(FTP_PORT));
        ftpClient.setControlEncoding("UTF-8");
        if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            if (ftpClient.login(FTP_USERNAME, FTP_PASSWORD)) {
                return true;
            }
        }
        disconnect();
        return false;
    }

    /**
     * 连接到FTP服务器
     * 
     * @param hostname
     *            主机名
     * @param port
     *            端口
     * @param username
     *            用户名
     * @param password
     *            密码
     * @return 是否连接成功
     * @throws IOException
     */
    public boolean connect(String hostname, int port, String username, String password)
            throws IOException {
        ftpClient.connect(hostname, port);
        ftpClient.setControlEncoding("UTF-8");
        if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            if (ftpClient.login(username, password)) {
                return true;
            }
        }
        disconnect();
        return false;
    }

    /**
     * 递归调用列举指定路径下所有文件
     * 
     * @param remotePath
     */
    public void listAllFiles(String remotePath) throws IOException {
        if (remotePath == null || "".equals(remotePath)) {
            remotePath = "/";
        }
        if (remotePath.startsWith("/") && remotePath.endsWith("/")) {
            FTPFile[] files = ftpClient.listFiles(remotePath);
            if (files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    String fileName = files[i].getName();
                    if (files[i].isFile()) {
                        log.debug("当前文件：" + fileName);
                    } else if (files[i].isDirectory()) {
                        if (!".".equals(fileName) && !"..".equals(fileName)) {
                            log.debug("当前目录:" + fileName);
                            listAllFiles(remotePath + fileName + "/");
                        }
                    }
                }
            } else {
                log.debug("该目录下没有文件");
            }
        } else {
            log.debug("远程文件目录正确写法为以/开头和结尾");
        }

    }
    
    /**
     * 
     * @param remotePath
     * @return
     * @throws IOException
     */
    public String[] listAllFileNames(String remotePath) throws IOException {
        if (remotePath == null || "".equals(remotePath)) {
            remotePath = "/";
        }
        String[] fileNameArray = null;
        if (remotePath.startsWith("/") && remotePath.endsWith("/")) {
            FTPFile[] files = ftpClient.listFiles(remotePath);
            fileNameArray =  new String[files.length];
            if (files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    String fileName = files[i].getName();
                    if (files[i].isFile()) {
                        log.debug("当前文件：" + fileName);
                        fileNameArray[i] = fileName;
                    } else if (files[i].isDirectory()) {
                        if (!".".equals(fileName) && !"..".equals(fileName)) {
                            log.debug("当前目录:" + fileName);
                            listAllFiles(remotePath + fileName + "/");
                        }
                    }
                }
            } else {
                log.debug("该目录下没有文件");
            }
        } else {
            log.debug("远程文件目录正确写法为以/开头和结尾");
        }
        return fileNameArray;
    }

    /**
     * 从FTP服务器上下载文件,支持断点续传，上传百分比汇报
     * 
     * @param remote
     *            远程文件路径
     * @param local
     *            本地文件路径
     * @return 上传的状态
     * @throws IOException
     */
    public DownloadStatus download(String remote, String local) throws IOException {
        // 设置被动模式
        ftpClient.enterLocalPassiveMode();
        // 设置以二进制方式传输
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        DownloadStatus result;

        // 检查远程文件是否存在
        FTPFile[] files = ftpClient.listFiles(new String(remote.getBytes("UTF-8"), "iso-8859-1"));
        if (files.length != 1) {
            log.debug("远程文件不存在");
            return DownloadStatus.Remote_File_Noexist;
        }

        long lRemoteSize = files[0].getSize();
        File f = new File(local);
        // 本地存在文件，进行断点下载
        if (f.exists()) {
            long localSize = f.length();
            // 判断本地文件大小是否大于远程文件大小
            if (localSize >= lRemoteSize) {
                log.debug("本地文件大于远程文件，下载中止");
                return DownloadStatus.Local_Bigger_Remote;
            }

            // 进行断点续传，并记录状态
            FileOutputStream out = new FileOutputStream(f, true);
            ftpClient.setRestartOffset(localSize);
            InputStream in = ftpClient.retrieveFileStream(new String(remote.getBytes("UTF-8"),
                    "iso-8859-1"));
            byte[] bytes = new byte[1024];
           // long step = lRemoteSize / 100;
           // long process = localSize / step;
            int c;
            while ((c = in.read(bytes)) != -1) {
                out.write(bytes, 0, c);
                localSize += c;
              //  long nowProcess = localSize / step;
              //  if (nowProcess > process) {
             //       process = nowProcess;
              //      if (process % 10 == 0)
            //            log.debug("下载进度：" + process);
                    // TODO 更新文件下载进度,值存放在process变量中
             //   }
            }
            in.close();
            out.close();
            boolean isDo = ftpClient.completePendingCommand();
            if (isDo) {
                result = DownloadStatus.Download_From_Break_Success;
            } else {
                result = DownloadStatus.Download_From_Break_Failed;
            }
        } else {
            OutputStream out = new FileOutputStream(f);
            InputStream in = ftpClient.retrieveFileStream(new String(remote.getBytes("UTF-8"),
                    "iso-8859-1"));
            byte[] bytes = new byte[1024];
          //  long step = lRemoteSize / 100;
          //  long process = 0;
            long localSize = 0L;
            int c;
            while ((c = in.read(bytes)) != -1) {
                out.write(bytes, 0, c);
                localSize += c;
             //   long nowProcess = localSize / step;
              //  if (nowProcess > process) {
               //     process = nowProcess;
             //       if (process % 10 == 0)
                      //  System.out.println("下载进度：" + process);
                    // TODO 更新文件下载进度,值存放在process变量中
             //   }
            }
            in.close();
            out.close();
            boolean upNewStatus = ftpClient.completePendingCommand();
            if (upNewStatus) {
                result = DownloadStatus.Download_New_Success;
            } else {
                result = DownloadStatus.Download_New_Failed;
            }
        }
        return result;
    }

    /**
     * 读取远程文件为流的方式
     * 
     * @param remoteFile
     * @return
     * @throws IOException
     */
    public InputStream download(String remoteFile) throws IOException {
    	// 设置被动模式
        ftpClient.enterLocalPassiveMode();
        // 设置以二进制方式传输
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        InputStream in = ftpClient.retrieveFileStream(remoteFile);
        return in;
    }

    /**
     * 输入流转换成字符串
     * 
     * @param is
     * @return
     */
    public String inputStream2String(InputStream is) {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = in.readLine()) != null) {
                buffer.append("\n" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 上传文件到FTP服务器，支持断点续传
     * 
     * @param local
     *            本地文件名称，绝对路径
     * @param remote
     *            远程文件路径，使用/home/directory1/subdirectory/file.ext
     *            按照Linux上的路径指定方式，支持多级目录嵌套，支持递归创建不存在的目录结构
     * @return 上传结果
     * @throws IOException
     */
    public UploadStatus upload(String local, String remote) throws IOException {
        // 设置PassiveMode传输
        ftpClient.enterLocalPassiveMode();
        // 设置以二进制流的方式传输
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.setControlEncoding("UTF-8");
        UploadStatus result;
        // 对远程目录的处理
        String remoteFileName = remote;
        if (remote.contains("/")) {
            remoteFileName = remote.substring(remote.lastIndexOf("/") + 1);
            // 创建服务器远程目录结构，创建失败直接返回
            if (createDirecroty(remote, ftpClient) == UploadStatus.Create_Directory_Fail) {
                return UploadStatus.Create_Directory_Fail;
            }
        }

        // 检查远程是否存在文件
        FTPFile[] files = ftpClient.listFiles(new String(remoteFileName.getBytes("UTF-8"),
                "iso-8859-1"));
        if (files.length == 1) {
            long remoteSize = files[0].getSize();
            File f = new File(local);
            long localSize = f.length();
            if (remoteSize == localSize) { // 文件存在
                return UploadStatus.File_Exits;
            } else if (remoteSize > localSize) {
                return UploadStatus.Remote_Bigger_Local;
            }

            // 尝试移动文件内读取指针,实现断点续传
            result = uploadFile(remoteFileName, f, ftpClient, remoteSize);

            // 如果断点续传没有成功，则删除服务器上文件，重新上传
            if (result == UploadStatus.Upload_From_Break_Failed) {
                if (!ftpClient.deleteFile(remoteFileName)) {
                    return UploadStatus.Delete_Remote_Faild;
                }
                result = uploadFile(remoteFileName, f, ftpClient, 0);
            }
        } else {
            File localFile = new File(local);
            if (!localFile.exists()) { // 本地文件不存在
                result = UploadStatus.LocalFile_notExists;
            } else {
                result = uploadFile(remoteFileName, new File(local), ftpClient, 0);
            }
        }
        return result;
    }

    /**
     * 将本地文件上传的远端路径上
     * 
     * @param localFile
     * @param remote
     * @return
     * @throws IOException
     */
    public UploadStatus upload(File localFile, String remote) throws IOException {
        // 设置PassiveMode传输
        ftpClient.enterLocalPassiveMode();
        // 设置以二进制流的方式传输
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.setControlEncoding("UTF-8");
        UploadStatus result;
        // 对远程目录的处理
        String remoteFileName = remote;
        if (remote.contains("/")) {
            remoteFileName = remote.substring(remote.lastIndexOf("/") + 1);
            // 创建服务器远程目录结构，创建失败直接返回
            if (createDirecroty(remote, ftpClient) == UploadStatus.Create_Directory_Fail) {
                return UploadStatus.Create_Directory_Fail;
            }
        }

        // 检查远程是否存在文件
        FTPFile[] files = ftpClient.listFiles(new String(remoteFileName.getBytes("UTF-8"),
                "iso-8859-1"));
        if (files.length == 1) {
            long remoteSize = files[0].getSize();
            long localSize = localFile.length();
            if (remoteSize == localSize) { // 文件存在
                return UploadStatus.File_Exits;
            } else if (remoteSize > localSize) {
                return UploadStatus.Remote_Bigger_Local;
            }

            // 尝试移动文件内读取指针,实现断点续传
            result = uploadFile(remoteFileName, localFile, ftpClient, remoteSize);

            // 如果断点续传没有成功，则删除服务器上文件，重新上传
            if (result == UploadStatus.Upload_From_Break_Failed) {
                if (!ftpClient.deleteFile(remoteFileName)) {
                    return UploadStatus.Delete_Remote_Faild;
                }
                result = uploadFile(remoteFileName, localFile, ftpClient, 0);
            }
        } else {
            result = uploadFile(remoteFileName, localFile, ftpClient, 0);
        }
        return result;
    }

    /**
     * 断开与远程服务器的连接
     * 
     * @throws IOException
     */
    public void disconnect() throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.disconnect();
        }
    }

    /**
     * 递归创建远程服务器目录
     * 
     * @param remote
     *            远程服务器文件绝对路径
     * @param ftpClient
     *            FTPClient对象
     * @return 目录创建是否成功
     * @throws IOException
     */
    public UploadStatus createDirecroty(String remote, FTPClient ftpClient) throws IOException {
        UploadStatus status = UploadStatus.Create_Directory_Success;
        String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
        if (!directory.equalsIgnoreCase("/")
                && !ftpClient.changeWorkingDirectory(new String(directory.getBytes("UTF-8"),
                        "iso-8859-1"))) {
            // 如果远程目录不存在，则递归创建远程服务器目录
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("UTF-8"),
                        "iso-8859-1");
                if (!ftpClient.changeWorkingDirectory(subDirectory)) {
                    if (ftpClient.makeDirectory(subDirectory)) {
                        ftpClient.changeWorkingDirectory(subDirectory);
                    } else {
                        log.debug("创建目录失败");
                        return UploadStatus.Create_Directory_Fail;
                    }
                }

                start = end + 1;
                end = directory.indexOf("/", start);

                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return status;
    }

    /**
     * 上传文件到服务器,新上传和断点续传
     * 
     * @param remoteFile
     *            远程文件名，在上传之前已经将服务器工作目录做了改变
     * @param localFile
     *            本地文件File句柄，绝对路径
     * @param processStep
     *            需要显示的处理进度步进值
     * @param ftpClient
     *            FTPClient引用
     * @return
     * @throws IOException
     */
    public UploadStatus uploadFile(String remoteFile, File localFile, FTPClient ftpClient,
            long remoteSize) throws IOException {
        UploadStatus status;
        // 显示进度的上传
        //long step = localFile.length() / 100;
       // long process = 0;
        long localreadbytes = 0L;
        RandomAccessFile raf = new RandomAccessFile(localFile, "r");
        OutputStream out = ftpClient.appendFileStream(new String(remoteFile.getBytes("UTF-8"),
                "iso-8859-1"));
        // 断点续传
        if (remoteSize > 0) {
            ftpClient.setRestartOffset(remoteSize);
          //  process = remoteSize / step;
            raf.seek(remoteSize);
            localreadbytes = remoteSize;
        }
        byte[] bytes = new byte[1024];
        int c;
        while ((c = raf.read(bytes)) != -1) {
            out.write(bytes, 0, c);
            localreadbytes += c;
         //   if (localreadbytes / step != process) {
          //      process = localreadbytes / step;
          //      System.out.println("上传进度:" + process);
                // TODO 汇报上传状态

          //  }
        }
        out.flush();
        raf.close();
        out.close();
        boolean result = ftpClient.completePendingCommand();
        if (remoteSize > 0) {
            status = result ? UploadStatus.Upload_From_Break_Success
                    : UploadStatus.Upload_From_Break_Failed;
        } else {
            status = result ? UploadStatus.Upload_New_File_Success
                    : UploadStatus.Upload_New_File_Failed;
        }
        return status;
    }

    /**
     * 输入流上传到远程目录下
     * 
     * @param iStream
     * @param newName
     * @return
     * @throws IOException
     */
    public UploadStatus uploadFile(InputStream iStream, String newName) throws IOException {
        // 设置PassiveMode传输
        ftpClient.enterLocalPassiveMode();
        // 设置以二进制流的方式传输
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.setControlEncoding("UTF-8");

        // 对远程目录的处理
        String remoteFileName = newName;
        if (newName.contains("/")) {
            remoteFileName = newName.substring(newName.lastIndexOf("/") + 1);
            // 创建服务器远程目录结构，创建失败直接返回
            if (createDirecroty(newName, ftpClient) == UploadStatus.Create_Directory_Fail) {
                return UploadStatus.Create_Directory_Fail;
            }
        }
        UploadStatus status = UploadStatus.Upload_New_File_Success;
        try {
            boolean flag = ftpClient.storeFile(remoteFileName, iStream);
            if (!flag) {
                status = UploadStatus.Upload_New_File_Failed;
            }
        } catch (IOException e) {
            status = UploadStatus.Upload_New_File_Failed;
        } finally {
            if (iStream != null) {
                iStream.close();
            }
        }
        return status;
    }
    
//    public static void main(String[] args) {
//    	
//    }

    /**
     * 重命名文件
     * 
     * @param oldFileName
     *            --原文件名
     * @param newFileName
     *            --新文件名
     */
    public RenameStatus renameFile(String oldFileName, String newFileName) throws IOException {
        RenameStatus status = RenameStatus.Rename_File_Success;
        // 设置PassiveMode传输
        ftpClient.enterLocalPassiveMode();
        // 设置以二进制流的方式传输
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.setControlEncoding("UTF-8");
        // 对远程目录的处理
        String oldName = oldFileName;
        String oldFilePath = "";
        if (oldName.contains("/")) {
            oldName = oldFileName.substring(oldFileName.lastIndexOf("/") + 1);
            oldFilePath = oldFileName.substring(0, oldFileName.lastIndexOf("/") + 1);
        }

        try {
            boolean flag = ftpClient.rename(oldFilePath
                    + new String(oldName.getBytes("UTF-8"), "iso-8859-1"), oldFilePath
                    + new String(newFileName.getBytes("UTF-8"), "iso-8859-1"));
            if (!flag) {
                status = RenameStatus.Rename_File_Failes;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            status = RenameStatus.Rename_File_Failes;
        }
        return status;
    }

    /**
     * 获得FTP 服务器下所有的文件名列表
     * 
     * @param regex
     * @return
     */
    public String[] getListFiels(String regex) throws IOException {
        String files[] = new String[0];
        try {
            files = ftpClient.listNames(regex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    /**
     * 返回上一级目录(父目录)
     */
    public void toParentDir() throws IOException {
        try {
            ftpClient.changeToParentDirectory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("返回到上层目录。");
    }

    /**
     * 变更工作目录
     * 
     * @param remoteDir
     *            --目录路径
     */
    public ChangeDirectoryStatus changeDir(String remoteDir) throws IOException {
        ChangeDirectoryStatus status = ChangeDirectoryStatus.Change_Directory_Success;
        String directory = remoteDir.substring(0, remoteDir.lastIndexOf("/") + 1);
        if (!directory.equalsIgnoreCase("/")
                && !ftpClient.changeWorkingDirectory(new String(directory.getBytes("UTF-8"),
                        "iso-8859-1"))) {
            // 如果远程目录不存在，则递归创建远程服务器目录
            status = ChangeDirectoryStatus.Change_Directory_Fail;
            log.debug("变更工作目录为:" + directory + "失败");
        } else {
            log.debug("变更工作目录为:" + directory);
        }
        return status;

    }

    /**
     * 产出远程目录文件
     * 
     * @param pathname
     *            远程文件路径
     * @return
     * @throws IOException
     */
    public DeleteStatus deleteFile(String pathname) throws IOException {
        DeleteStatus status = DeleteStatus.Delete_File_Success;
        // 对远程目录的处理
//        String remoteFileName = pathname;
//        if (pathname.contains("/")) {
//            remoteFileName = pathname.substring(pathname.lastIndexOf("/") + 1);
//            // 创建服务器远程目录结构，创建失败直接返回
//            if (changeDir(pathname) == ChangeDirectoryStatus.Change_Directory_Fail) {
//                status = DeleteStatus.Delete_File_Failed;
//                return status;
//            }
//        }
//
//        boolean flag = true;
//        try {
////        	ftpClient.dele(pathname);
//            flag = ftpClient.deleteFile(remoteFileName);
//            if (flag) {
//                log.debug("成功将文件删除 文件名：" + pathname);
//            } else {
//                log.debug("删除文件：" + pathname + "失败");
//                status = DeleteStatus.Delete_File_Failed;
//            }
//        } catch (Exception e) {
//            log.debug("删除FTP文件失败 文件名：" + pathname);
//            status = DeleteStatus.Delete_File_Failed;
//        }
        return status;
    }

    /**
     * 上传文件返回文件相对路径
     * @param file 文件
     * @param fileName 文件名称
     * @param prefixPathStr 文件路径前缀
     * @param prefixStr 文件名称前缀
     * @author githuban.zhou
     * @return 上传后的文件相对路径
     */
    public String toUploadFile(File file, String fileName, String prefixPathStr, String prefixStr) {
        String uploadUrlStr = "";
        FtpUtil myFtp = null;
        if (instance == null) {
            // 上传文件
            myFtp = FtpUtil.getInstance();
        } else {
            myFtp = instance;
        }
        if (file != null) {
            try {
                // 存储的文件名称
                 String fileExtendName = fileName.substring(fileName.lastIndexOf('.'));
                 String name = prefixStr + "_" + System.currentTimeMillis() + fileExtendName;
                if (myFtp.connect()) {
                    myFtp.upload(file.getCanonicalPath(), prefixPathStr + name);
                    uploadUrlStr = prefixPathStr + name;
                    myFtp.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            } finally {
                try {
                    if (null != myFtp) {
                        myFtp.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        }
        return uploadUrlStr;
    }
    
    public enum UploadStatus {
        Create_Directory_Fail, // 远程服务器相应目录创建失败
        Create_Directory_Success, // 远程服务器闯将目录成功
        Upload_New_File_Success, // 上传新文件成功
        Upload_New_File_Failed, // 上传新文件失败
        File_Exits, // 文件已经存在
        Remote_Bigger_Local, // 远程文件大于本地文件
        Upload_From_Break_Success, // 断点续传成功
        Upload_From_Break_Failed, // 断点续传失败
        Delete_Remote_Faild, // 删除远程文件失败
        LocalFile_notExists; // 本地文件不存在
    }

    public enum DownloadStatus {
        Remote_File_Noexist, // 远程文件不存在
        Download_New_Success, // 下载文件成功
        Download_New_Failed, // 下载文件失败
        Local_Bigger_Remote, // 本地文件大于远程文件
        Download_From_Break_Success, // 断点续传成功
        Download_From_Break_Failed; // 断点续传失败
    }

    public enum ChangeDirectoryStatus {
        Change_Directory_Success, // 跳转指定目录成功
        Change_Directory_Fail; // 跳转指定目录失败
    }

    public enum DeleteStatus {
        Delete_File_Success, // 删除指定文件成功
        Delete_File_Failed; // 删除指定文件失败
    }

    public enum RenameStatus {
        Rename_File_Failes, // 重命名文件成功
        Rename_File_Success; // 重命名文件失败
    }
    
    public InputStream getInputStreamByPath(String remote){
    	try {
//    		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
 			return ftpClient.retrieveFileStream(remote);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    public void copyFileFromTo(String from, String to) throws IOException{
    	// 设置被动模式
        ftpClient.enterLocalPassiveMode();
        // 设置以二进制方式传输
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        
        ftpClient.setBufferSize(1024);
    	ByteArrayOutputStream fos=new ByteArrayOutputStream();
    	boolean flag = ftpClient.retrieveFile(from, fos);
    	fos.close();
    	if (flag) {    		
    		InputStream in=new ByteArrayInputStream(fos.toByteArray());
    		uploadFile(in, to);
    		in.close();
    	}
    }
    
    public static void main(String[] args) throws IOException {
//        try {
//            FtpUtil myFtp = FtpUtil.getInstance();
//            
//            myFtp.connect();
////            myFtp.download("/test/asd/哈哈.log", "e:/11.log");
//            InputStream in =myFtp.getInputStreamByPath("swf/abc.epub");
//            System.out.println(in);
//            myFtp.disconnect();
//        } catch (IOException e) {
//            System.out.println("连接FTP出错：" + e.getMessage());
//            e.printStackTrace();
//        }
        
        try {
            FtpUtil myFtp = FtpUtil.getInstance();
            
            myFtp.connect();
            myFtp.copyFileFromTo("12345.jpg", "54321.jpg");
            myFtp.disconnect();
        } catch (IOException e) {
            System.out.println("连接FTP出错：" + e.getMessage());
            e.printStackTrace();
        }
        
        
//    	FTPClient ftpClient = FtpUtil.getInstance();
//		try {
//			ftpClient.connect();
//			// 设置PassiveMode传输
//			ftpClient.enterLocalPassiveMode();
//			// 设置以二进制流的方式传输
//			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//			
//			ftpClient.setControlEncoding("UTF-8");
//			fu.disconnect();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
        
    }
}
