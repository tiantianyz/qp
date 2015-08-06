package junit.common.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wxly.common.entity.AreaInfo;
import com.wxly.common.service.AreaInfoService;

public class AreaInfoServiceTest {

	@Test
	public void insertTest() {
		AreaInfo areaInfo = new AreaInfo();
		areaInfo.setChineseName("测试数据Name");
		areaInfo.setCode("testDataCode");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		AreaInfoService service = (AreaInfoService)context.getBean("areaInfoService");
		try {
			service.insert(areaInfo);
			System.out.println("success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		AreaInfo areaInfo = new AreaInfo();
		areaInfo.setChineseName("测试数据Name");
		areaInfo.setCode("testDataCode");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		AreaInfoService service = (AreaInfoService)context.getBean("areaInfoService");
		try {
			service.insert(areaInfo);
			System.out.println("success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
