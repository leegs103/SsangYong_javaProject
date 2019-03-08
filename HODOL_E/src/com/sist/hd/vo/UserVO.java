package com.sist.hd.vo;

public class UserVO extends DTO{
	private String name;//유저이름
	private String id;//유저아이디
	private String password;//유저비밀번호
	private String birth;//유저생년월일
	private String address;//유저주소
	private String tel;//유저전화번호
	private String MsgId; //로그인 성공여부를 보여주는 메세지아이디(1: 성공, -1: 아이디오류, -2: 비밀번호오류)
	
	public UserVO() { }
	
	public UserVO(String name, String id, String password, String birth, String address, String tel) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.birth = birth;
		this.address = address;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	@Override
	public String toString() {
		return "UserVO [name=" + name + ", id=" + id + ", password=" + password + ", birth=" + birth + ", address="
				+ address + ", tel=" + tel + ", MsgId=" + MsgId + "]";
	}

}