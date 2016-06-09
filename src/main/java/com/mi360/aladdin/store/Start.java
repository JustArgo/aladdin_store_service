package com.mi360.aladdin.store;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mi360.aladdin.store.domain.Store;
import com.mi360.aladdin.store.service.IStoreService;

public class Start {

	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext-store.xml" });
		context.start();
		System.out.println("店铺微服务启动");
		
		IStoreService storeService = context.getBean(IStoreService.class);
		
		/*storeService.addProductsIntoStore("", "2", new Integer[]{22,23,24,25});
		storeService.addProductsIntoStore("", "3", new Integer[]{22,23,24,25,26});
		*/
		int ret = storeService.recommendProducts("", "3", new Integer[]{23,24});
		System.out.println("ret:"+ret);
		
		while(true){
			Thread.sleep(1000);
		}
	}
	
}
