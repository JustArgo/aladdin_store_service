package com.mi360.aladdin.store.service;

import java.util.Date;

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
	
	/**
	 * 查询某个用户的店铺 在指定时间段内 下单的数量
	 * @param requestId
	 * @param mqId
	 * @param startTime 起始时间(查询的时候>=起始时间) 可传入空值,代表不限制起始时间
	 * @param endTime	结束时间(查询的时候<=起始时间) 可传入空值,代表不限制结束时间
	 * @return
	 */
	int getOrderCount(String requestId, String mqId, Date startTime, Date endTime);
	
	/**
	 * 查询店铺中的订单
	 * @param requestId
	 * @param mqId
	 * @param startTime
	 * @param endTime
	 */
	void getOrder(String requestId, String mqId, Date startTime, Date endTime);	
}
