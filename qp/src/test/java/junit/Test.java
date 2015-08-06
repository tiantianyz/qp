package junit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wxly.core.util.FtpUtil;
import com.wxly.product.entity.ProPicture;

/**
 * Description:
 *
 * Author: Ding Chengyun
 * CreateDate:2014-12-20
 * Version：V0.1
 */
public class Test {

	public static void main(String[] args) {
		List<String> pic = new ArrayList<String>();
		pic.add("12345.jpg");
		pic.add("8dc73ddd-cd0c-4b48-9561-a89a94eef56f.jpg");
		pic.add("banner1418910570605.jpg");
		
		pic.add("product/trip/e7d5c2ab-54c6-4670-90ab-552a3fab22ef.jpg");
		pic.add("product/trip/4b125585-ea67-4c0b-9769-af21911e4ba9.jpg");
//		pic.add("banner1418910570605.jpg");
		int i = 10000;
		try {
			FtpUtil ft = FtpUtil.getInstance();
			ft.connect();
//			for (String p : pic) {
//				ft.copyFileFromTo(p, p+(i++));
//			}
			
			String picUrl = "";
			String path = "";
			String picName = "";
			String picType = "";
			for (String pp : pic) {
				picUrl = pp;
				path = picUrl.substring(0,picUrl.lastIndexOf("/")+1);
				picName = picUrl.substring(picUrl.lastIndexOf("/")+1,picUrl.lastIndexOf(".")) + "-copy";
				picType = picUrl.substring(picUrl.lastIndexOf("."));
				ft.copyFileFromTo(picUrl, path + picName + picType);
//				ft.copyFileFromTo(picUrl, path+picName+picType);
			}
			ft.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
