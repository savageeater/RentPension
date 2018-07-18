package com.lhs.pension.dto;

public class RentPension {
	private int no;
	private String name;
	private int price;
	private String img;
	private String info;
	private int minp;
	private int maxp;
	private int region;
	private int spa;
	private int pool;
	private int toilet;
	private int room;
	private int breakfast;
	private int wifi;

	@Override
	public String toString() {
		return " 예약번호 : " + no + " 펜션 이름 : " + name + " 총 구매 가격 : " + price 
				+"지역 : " + region + " 화장실 갯수 : " + toilet + "방 갯수 : " + room + " 기타 정보 : " + info + " ] ";
	}

	
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getMinp() {
		return minp;
	}
	public void setMinp(int minp) {
		this.minp = minp;
	}
	public int getMaxp() {
		return maxp;
	}
	public void setMaxp(int maxp) {
		this.maxp = maxp;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public int getSpa() {
		return spa;
	}
	public void setSpa(int spa) {
		this.spa = spa;
	}
	public int getPool() {
		return pool;
	}
	public void setPool(int pool) {
		this.pool = pool;
	}
	public int getToilet() {
		return toilet;
	}
	public void setToilet(int toilet) {
		this.toilet = toilet;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}
	

}
