package com.sist.hd.vo;

public class StoreVO extends DTO{
	private String storeTel;//세탁소 전화번호
	private String storeName;//세탁소 이름
	private String storAddress;//세탁소 주소
	
	
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorAddress() {
		return storAddress;
	}
	public void setStorAddress(String storAddress) {
		this.storAddress = storAddress;
	}
}
