package com.sist.hd.vo;

import java.util.List;

import javax.swing.JTable;

public class PayVO extends DTO{
	private String launName; //세탁소 이름
	private String userId; //사용자Id
	private String payId; //결제 Id (key값)
	private String launList; //세탁물 리스트
	private String userAddress; //사용자 주소
	private String totalPrice; //결제할 금액
	private String pickupTime; //픽업 시간
	private String deliveryTime; //배달시간
	
	public PayVO(){	}
	
	public PayVO(String launName, String userId, String payId,String launList, String userAddress,String totalPrice,String pickupTime,String deliveryTime ){
		super();
		this.launName = launName;
		this.userId = userId;
		this.payId= payId;
		this.launList = launList;
		this.userAddress= userAddress; 
		this.totalPrice = totalPrice; 
		this.pickupTime = pickupTime; 
		this.deliveryTime = deliveryTime;	
	}
	
	public String getLaunName() {
		return launName;
	}

	public void setLaunName(String launName) {
		this.launName = launName;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLaunList() {
		return launList;
	}


	public void setLaunList(String launList) {
		this.launList = launList;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}
	
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Override
	public String toString() {
		return "PayVO [launName=" + launName + ", userId=" + userId + ", payId=" + payId + ", launList=" + launList
				+ ", userAddress=" + userAddress + ", totalPrice=" + totalPrice + ", pickupTime=" + pickupTime
				+ ", deliveryTime=" + deliveryTime + "]";
	}
	
}
