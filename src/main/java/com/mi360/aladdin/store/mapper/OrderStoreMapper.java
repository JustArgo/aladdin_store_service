package com.mi360.aladdin.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mi360.aladdin.store.domain.OrderStore;

public interface OrderStoreMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(OrderStore record);

    int insertSelective(OrderStore record);

    OrderStore selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(OrderStore record);

    int updateByPrimaryKey(OrderStore record);
    
    int getOrderCount(@Param("storeID")Integer storeID, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
    
    List<OrderStore> getOrderStore(@Param("storeID")Integer storeID, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
}