package com.mi360.aladdin.store.service.impl;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.mi360.aladdin.store.domain.Store;
import com.mi360.aladdin.store.domain.StoreProduct;
import com.mi360.aladdin.store.mapper.StoreMapper;
import com.mi360.aladdin.store.mapper.StoreProductMapper;
import com.mi360.aladdin.store.service.IStoreService;
import com.mi360.aladdin.store.util.LogUtil;

public class StoreServiceImpl implements IStoreService{

	public static final String serviceName = "店铺微服务";
	
	@Autowired
	private StoreMapper storeMapper;

	@Autowired
	private StoreProductMapper storeProductMapper;
	
	@Override
	public int createStore(String requestId, String mqId, String title,
			String logoPath, String abstraction) {
		
		LogUtil.logInput(serviceName, "createStore", requestId, mqId);
		
		Store store = new Store();
		store.setAbstraction(abstraction);
		store.setInsertTime(new Date());
		store.setLogoPath(logoPath);
		store.setMqID(mqId);
		store.setStatus("OK#");
		store.setTitle(title);
		
		storeMapper.insertSelective(store);
		
		LogUtil.logOutput(serviceName, "createStore", requestId, store.getID());
		
		return store.getID();
		
	}

	@Override
	public Store getStore(String requestId, String mqId) {
		
		LogUtil.logInput(serviceName, "getStore", requestId, mqId);
		
		Store store = null;
		
		if(mqId!=null){
			store = storeMapper.selectByMqID(mqId);
		}
		
		LogUtil.logOutput(serviceName, "getStore", requestId, store);
		
		return store;
	}

	@Override
	public int updateStoreInfo(String requestId, String mqId, String title,
			String abstraction, String logoPath) {
		
		LogUtil.logInput(serviceName, "updateStoreInfo", requestId, mqId, title, abstraction, logoPath);
		
		int rows = 0;
		
		if(mqId!=null){
			
				Store store = storeMapper.selectByMqID(mqId);
				if(store!=null){
					store.setAbstraction(abstraction);
					store.setTitle(title);
					store.setLogoPath(logoPath);
					store.setUpdateTime(new Date());
					rows = storeMapper.updateByPrimaryKeySelective(store);
				}
			
		}
		
		return rows;
	}

	@Override
	public int addProductsIntoStore(String requestId, String mqId,
			Integer[] productIds) {
		
		LogUtil.logInput(serviceName, "addProductsIntoStore", requestId, mqId, Arrays.toString(productIds));
		
		int ret = 0;
		
		if(mqId!=null){
			
			Store store = storeMapper.selectByMqID(mqId);
			if(store!=null && productIds!=null && productIds.length>0){
				for(int i=0;i<productIds.length;i++){
					StoreProduct storeProduct = new StoreProduct();
					storeProduct.setInsertTime(new Date());
					storeProduct.setProductID(productIds[i]);
					storeProduct.setRecommend(0);
					storeProduct.setSortOrder(1);
					storeProduct.setStatus("OK#");
					storeProduct.setStoreID(store.getID());
					storeProductMapper.insertSelective(storeProduct);
				}
				ret = productIds.length;
			}
		}
		
		LogUtil.logOutput(serviceName, "addProductsIntoStore", requestId, ret);
		
		return ret;
	}

	@Override
	public int delProductsFromStore(String requestId, String mqId,
			Integer[] productIds) {
		
		LogUtil.logInput(serviceName, "delProductsFromStore", requestId, mqId, Arrays.toString(productIds));
		
		int ret = 0;
		
		if(mqId!=null && productIds!=null && productIds.length>0){
			
			Store store = storeMapper.selectByMqID(mqId);
			if(store!=null){
				storeProductMapper.cancelProxy(store.getID(), productIds);
				ret = productIds.length;
			}
			
		}
		
		LogUtil.logOutput(serviceName, "delProductsFromStore", requestId, ret);
		
		return ret;
	}

	@Override
	public int topProductInStore(String requestId, String mqId,
			Integer productId) {
		
		LogUtil.logInput(serviceName, "topProductInStore", requestId, mqId, productId);
		
		int ret = 0;
		
		if(mqId!=null){
			Store store = storeMapper.selectByMqID(mqId);
			if(store!=null){
				ret = storeProductMapper.topProduct(store.getID(), productId);
			}
		}
		
		LogUtil.logOutput(serviceName, "topProductInStore", requestId, ret);
		
		return ret;
	}

	@Override
	public int recommendProducts(String requestId, String mqId,
			Integer[] productIds) {
		
		LogUtil.logInput(serviceName, "recommendProducts", requestId, Arrays.toString(productIds));
		
		int ret = 0;
		if(mqId!=null && productIds!=null && productIds.length>0){
			
			Store store = storeMapper.selectByMqID(mqId);
			if(store!=null){
				ret = storeProductMapper.recommend(store.getID(), productIds);
			}
			
		}
		
		LogUtil.logOutput(serviceName, "recommendProducts", requestId, ret);
		
		return ret;
	}
	
	

}
