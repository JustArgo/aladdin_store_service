package com.mi360.aladdin.store.mapper;

import org.apache.ibatis.annotations.Param;

import com.mi360.aladdin.store.domain.StoreProduct;

public interface StoreProductMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(StoreProduct record);

    int insertSelective(StoreProduct record);

    StoreProduct selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(StoreProduct record);

    int updateByPrimaryKey(StoreProduct record);
    
    int cancelProxy(@Param("storeID")Integer storeID, @Param("productIds")Integer[] productIds);
    
    int topProduct(@Param("storeID")Integer storeID, @Param("productId")Integer productId);
    
    int recommend(@Param("storeID")Integer storeID, @Param("productIds")Integer[] productIds);
}