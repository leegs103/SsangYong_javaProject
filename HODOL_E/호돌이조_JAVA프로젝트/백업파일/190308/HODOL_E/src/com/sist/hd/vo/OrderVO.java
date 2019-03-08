package com.sist.hd.vo;

public class OrderVO extends DTO{
	private String storeKey; //세탁소 키값
	private String storeName; //세탁소 이름
	private String storeTel; //세탁소 전화번호
	private String storeAddress; //세탁소 주소
	//private String price; //상품 가격
	
	public String getStoreKey() {
		return storeKey;
	}
	public void setStoreKey(String storeKey) {
		this.storeKey = storeKey;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	/*
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	*/
}
