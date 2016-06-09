package com.mi360.aladdin.store.mapper;

import com.mi360.aladdin.store.domain.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
    
    Store selectByMqID(String mqID);
    
}