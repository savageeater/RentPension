package com.lhs.pension.dto;

public class RentReserve {
	private int regno;
	private int no;
	private int qty;
	private int dday;
	private String rday;
	private int wifi;
	private String memid;
	private int breakfast;
	
	
	@Override
	public String toString() {
		return "예약정보 :" + "예약 인원 : " + qty + " 예약 기간 : " + dday + " 예약 일자 : " + rday + " 예약 ID : " + memid;
	}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public int getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}
	
}