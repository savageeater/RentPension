package com.lhs.pension.dto;

public class ReserveView {
	private String img;
	private String name;
	private int price;
	private int qty;
	private int dday;
	private String rday;
	private String memid;
	private String breakfast;
	private int regno;
	private int minp;
	
	public int getMinp() {
		return minp;
	}
	public void setMinp(int minp) {
		this.minp = minp;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}

	// 요금정보
	public String getFeeInfo() {
		
		String feeString = "";
		int fee =0;
		int a, b;
		feeString += "펜션 예약금:" + (a = getPrice()*dday);
		fee =(a+(qty-minp)*10000);
		feeString += " [ 총계: " + (fee)+" ]";
		return feeString;
	}

	// 예약확인 정보 한 row생성 소스 만들기
	public String getReverseInfoRow(String color) {
		StringBuffer trBuffer = new StringBuffer();
		trBuffer.append("<tr align='center' bgcolor='" + color + "'>");
			int a, b;
			// 예약번호 // 차량이미지// 차종 // 예약일 // 대여일수  // 대여수량 // 보험 // wifi// navi // bbst // 대여금액내역// 수정 // 삭제
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + getRegno() + "");
			trBuffer.append("</td>");
			
			trBuffer.append("<td height='50' width='10%'>");
			trBuffer.append("<img width='150' height='70' alt='' src='resource/img/" + getImg() + "' >");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + getName() + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='10%'>");
			trBuffer.append("" + getRday() + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + getDday() + "");
			trBuffer.append("</td>");
			
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + getQty() + "");
			trBuffer.append("</td>");
			//

			trBuffer.append("<td height='50' >");
			trBuffer.append("" + getFeeInfo() + "");
			trBuffer.append("</td>");
			
			//trBuffer.append("</tr>");

		
		return trBuffer.toString();
	}
	
	
	
	
}
