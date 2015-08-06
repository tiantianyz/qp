package com.qp.basic.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qp.basic.util.FtpUtil.DeleteStatus;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {
	/**
	 * 日志
	 */
	private static Log log = LogFactory.getLog(ImageUtil.class);
	
	/**
	 * 压缩图片
	 * @param sourceFile 源文件
	 * @param width 需要压缩成的宽
	 * @param height 需要压缩成的高
	 * @param fileName 文件名称
	 * @return File
	 * @throws ImageFormatException 异常
	 * @throws IOException 异常
	 */
	public static File createThemestorePic(File sourceFile, Double width, Double height, String fileName)
			throws ImageFormatException, IOException {
		String basePath = SysConstUtil.TEMP_FILE;
		File tempFile = new File(basePath.substring(0, basePath.lastIndexOf("/")));
		String format = fileName.split("\\.")[1];
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		tempFile = new File(basePath + fileName);
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		BufferedImage image = ImageIO.read(sourceFile);

		// 计算新的图面宽度和高度
		int newWidth = 0;
		int newHeight = 0;

		if(width.equals(height)){
			if(image.getHeight() >image.getWidth()){
				image = image.getSubimage(0, 0, image.getWidth(), image.getWidth());
	        }else{
	        	image = image.getSubimage(0, 0, image.getHeight(), image.getHeight());
	        }
//	        ImageIO.write(image, format, new File("F:\\" + "_" + new Date().getTime() + "." + format));
			newWidth = width.intValue();
	        newHeight = height.intValue();
		}else{
			newWidth = width.intValue();
	        newHeight = height.intValue();
			log.debug("裁剪图片w = " + newWidth);
			log.debug("裁剪图片h = " + newHeight);
		}
		BufferedImage bfImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

		Color c = Color.WHITE;
		Graphics2D newG = bfImage.createGraphics();
		newG.setColor(c);
		newG.fillRect(0, 0, newWidth, newHeight);
		newG.drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0,
				newWidth, newHeight, c, null);
		newG.dispose();

		// 图片跟据长宽留白，生成正方形的空白画布
		BufferedImage oldpic = new BufferedImage(width.intValue(), height.intValue(),
				BufferedImage.TYPE_INT_RGB);

		// 在新的画布上生成原图的缩略图
		Graphics2D g = oldpic.createGraphics();
		g.setColor(c);
		g.fillRect(0, 0, width.intValue(), height.intValue());
		g.drawImage(bfImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0,
				newWidth, newHeight, c, null);
		g.dispose();
		//ImageIO.write(bfImage, format, new File("F:\\" + "34_" + new Date().getTime() + "." + format));

		FileOutputStream os = new FileOutputStream(tempFile); // 输出到文件流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		// JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bfImage);
		// 压缩质量
		// jep.setQuality(1F, true);
		encoder.encode(oldpic);
		os.close();
		log.debug("创建缩略图成功");

		return tempFile;
	}
	/**
	 * 压缩图片
	 * @param sourceFile 源文件
	 * @param width 需要压缩成的宽
	 * @param height 需要压缩成的高
	 * @param fileName 文件名称
	 * @return File
	 * @throws ImageFormatException 异常
	 * @throws IOException 异常
	 */
	public static File createPic(InputStream in, Double width, Double height, String fileName)
			throws ImageFormatException, IOException {
		String basePath = SysConstUtil.TEMP_FILE;
		File tempFile = new File(basePath.substring(0, basePath.lastIndexOf("/")));
		String format = fileName.split("\\.")[1];
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		tempFile = new File(basePath + fileName);
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		BufferedImage image = ImageIO.read(in);
		
		// 计算新的图面宽度和高度
		int newWidth = 0;
		int newHeight = 0;
		
		if(width.equals(height)){
			if(image.getHeight() >image.getWidth()){
				image = image.getSubimage(0, 0, image.getWidth(), image.getWidth());
			}else{
				image = image.getSubimage(0, 0, image.getHeight(), image.getHeight());
			}
//	        ImageIO.write(image, format, new File("F:\\" + "_" + new Date().getTime() + "." + format));
			newWidth = width.intValue();
			newHeight = height.intValue();
		}else{
			newWidth = width.intValue();
			newHeight = height.intValue();
			log.debug("裁剪图片w = " + newWidth);
			log.debug("裁剪图片h = " + newHeight);
		}
		BufferedImage bfImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
		
		Color c = Color.WHITE;
		Graphics2D newG = bfImage.createGraphics();
		newG.setColor(c);
		newG.fillRect(0, 0, newWidth, newHeight);
		newG.drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0,
				newWidth, newHeight, c, null);
		newG.dispose();
		
		// 图片跟据长宽留白，生成正方形的空白画布
		BufferedImage oldpic = new BufferedImage(width.intValue(), height.intValue(),
				BufferedImage.TYPE_INT_RGB);
		
		// 在新的画布上生成原图的缩略图
		Graphics2D g = oldpic.createGraphics();
		g.setColor(c);
		g.fillRect(0, 0, width.intValue(), height.intValue());
		g.drawImage(bfImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0,
				newWidth, newHeight, c, null);
		g.dispose();
		//ImageIO.write(bfImage, format, new File("F:\\" + "34_" + new Date().getTime() + "." + format));
		
		FileOutputStream os = new FileOutputStream(tempFile); // 输出到文件流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		// JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bfImage);
		// 压缩质量
		// jep.setQuality(1F, true);
		encoder.encode(oldpic);
		os.close();
		log.debug("创建缩略图成功");
		
		return tempFile;
	}
	
	 public static File compressPic(File file,int outputWidth, int outputHeight,
    		 boolean proportion, String fileName) {   
         try {   
             Image img = ImageIO.read(file);   
             // 判断图片格式是否正确   
             if (img.getWidth(null) == -1) {  
                 System.out.println(" can't read,retry!" + "<BR>");   
                 return null;   
             } else {   
                 int newWidth; int newHeight;   
                 // 判断是否是等比缩放   
                 if (proportion == true) {   
                     // 为等比缩放计算输出的图片宽度及高度   
                     double rate1 = ((double) img.getWidth(null)) /  (double)outputWidth + 0.1;   
                     double rate2 = ((double) img.getHeight(null)) / (double)outputHeight + 0.1;   
                     // 根据缩放比率大的进行缩放控制   
                     double rate = rate1 > rate2 ? rate1 : rate2;   
                     newWidth = (int) (((double) img.getWidth(null)) / rate);   
                     newHeight = (int) (((double) img.getHeight(null)) / rate);   
                 } else {   
                     newWidth = outputWidth; // 输出的图片宽度   
                     newHeight = outputHeight; // 输出的图片高度   
                 }   
                BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);   
                  
                /* 
                 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 
                 * 优先级比速度高 生成的图片质量比较好 但速度慢 
                 */   
                tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);  
                String basePath = SysConstUtil.TEMP_FILE;
                File tempFile = new File(basePath + fileName);
                FileOutputStream out = new FileOutputStream(tempFile);  
                // JPEGImageEncoder可适用于其他图片类型的转换   
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
                encoder.encode(tag);   
                out.close();   
                return tempFile;   
             }   
         } catch (IOException ex) {   
             ex.printStackTrace();   
         }   
         return null;
    } 
	 public static File compressPicStream(InputStream in,int outputWidth, int outputHeight,
			 String fileName,String path) {
		 try {   
			 Image img = ImageIO.read(in);
			 // 判断图片格式是否正确   
			 if (img.getWidth(null) == -1) {  
				 System.out.println(" can't read,retry!" + "<BR>");   
				 return null;   
			 } else {   
				 int newWidth; int newHeight;
				 // 为等比缩放计算输出的图片宽度及高度   
				 double rate = ((double) img.getWidth(null)) /  (double)outputWidth;   
				 // 根据缩放比率大的进行缩放控制   
				 newWidth = (int) (((double) img.getWidth(null)) / rate);
				 newHeight = (int) (((double) img.getHeight(null)) / rate);   
				 BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);
				 Graphics ga = tag.getGraphics();
				 /* 
				  * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 
				  * 优先级比速度高 生成的图片质量比较好 但速度慢 
				  */   
				 ga.drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
				 String basePath = SysConstUtil.TEMP_FILE;
				 if(path!=null&&!path.equals("ad")){
					 Image base = ImageIO.read(new FileInputStream(basePath+"base-1.png"));
					 ga.drawImage(base.getScaledInstance(150,60, Image.SCALE_SMOOTH), newWidth-160, newHeight-60,null);
				 }
				 File tempFile = new File(basePath+File.separator+path+File.separator+fileName);
				 FileOutputStream out = new FileOutputStream(tempFile);
				 // JPEGImageEncoder可适用于其他图片类型的转换 
				 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
				 encoder.encode(tag);   
				 out.close();   
				 return tempFile;   
			 }   
		 } catch (IOException ex) {   
			 ex.printStackTrace();   
		 }   
		 return null;
	 } 
	
	
	/**
	 * 调用FTP工具类删除文件
	 * @param name 文件名
	 * @param index 标识
	 * @return UploadStatus
	 * @throws IOException 异常
	 * @author maruiyun
	 */
	public static DeleteStatus deleteFile(String pathName) throws IOException {
		FtpUtil myFtp = FtpUtil.getInstance();
		myFtp.connect();
		DeleteStatus status = myFtp.deleteFile(pathName);
		myFtp.disconnect();
		return status;
	}
	public static void main(String[] args)throws Exception{
		SysConstUtil.TEMP_FILE="D:/project/outter/qp/ftp/";
		InputStream in = new FileInputStream(new File("D:/project/outter/qp/ftp/one.jpg"));
		ImageUtil.compressPicStream(in, 480, 800,"one1.jpg", "");
	}
}
