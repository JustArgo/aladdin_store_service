package com.mi360.aladdin.store.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺和订单的关联对象
 * @author 黄永宗
 *
 */
public class OrderStore implements Serializable {

	private static final long serialVersionUID = -8604761129863773323L;

	/** 主键ID */
	private Integer ID;

	/** 订单ID */
    private Integer orderID;

    /** 店铺ID */
    private Integer storeID;

    /** 插入时间 */
    private Date insertTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getStoreID() {
        return storeID;
    }

    public void setStoreID(Integer storeID) {
        this.storeID = storeID;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", orderID=").append(orderID);
        sb.append(", storeID=").append(storeID);
        sb.append(", insertTime=").append(insertTime);
        sb.append("]");
        return sb.toString();
    }
}