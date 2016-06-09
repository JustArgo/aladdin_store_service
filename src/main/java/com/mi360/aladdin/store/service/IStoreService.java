package com.mi360.aladdin.store.service;

import com.mi360.aladdin.store.domain.Store;

public interface IStoreService {

	/**
	 * 开店
	 * @param requestId
	 * @param mqId
	 * @param title
	 * @param logoPath
	 * @param abstraction
	 * @return
	 */
	int createStore(String requestId, String mqId, String title, String logoPath, String abstraction);

	/**
	 * 查询店铺
	 * @param requestId
	 * @param mqId
	 * @return
	 */
	Store getStore(String requestId, String mqId);
	
	/**
	 * 更新店铺信息
	 * @param requestId
	 * @param mqId
	 * @param title
	 * @param abstraction
	 * @param logoPath
	 * @return
	 */
	int updateStoreInfo(String requestId, String mqId, String title,String abstraction, String logoPath);
	
	/**
	 * 将商品添加都店铺中 (代理)
	 * @param requestId
	 * @param mqId
	 * @param productIds
	 * @return
	 */
	int addProductsIntoStore(String requestId, String mqId, Integer[] productIds);
	
	/**
	 * 取消代理店铺中的商品
	 * @param requestId
	 * @param mqId
	 * @param productIds
	 * @return
	 */
	int delProductsFromStore(String requestId, String mqId, Integer[] productIds);
	
	/**
	 * 置顶店铺中的商品
	 * @param requestId
	 * @param mqId
	 * @param productId
	 * @return
	 */
	int topProductInStore(String requestId, String mqId, Integer productId);
	
	/**
	 * 将店铺中的商品设为店长推荐
	 * @param requestId
	 * @param mqId
	 * @param productIds
	 * @return
	 */
	int recommendProducts(String requestId, String mqId, Integer[] productIds);
	
}
