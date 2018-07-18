package com.lhs.pension.common;

import com.lhs.pension.dto.RentPension;

public class RentPensionParsing {
	public static RentPension parsing(String target) throws Exception{
		//"0/SONATA/3/50000/4/����/sonata.jpg/����������"
		String[] tokens = target.split("/");
		RentPension pension = new RentPension();
		String errormsg="";
		try {
			
			//pension.setNo(0);
			pension.setName(tokens[0]);
			pension.setPrice(Integer.parseInt(tokens[1]));
			pension.setImg(tokens[2]);
			pension.setInfo(tokens[3]);
			pension.setMinp(Integer.parseInt(tokens[4]));
			pension.setMaxp(Integer.parseInt(tokens[5]));
			pension.setRegion(Integer.parseInt(tokens[6]));
			pension.setSpa(Integer.parseInt(tokens[7]));
			pension.setPool(Integer.parseInt(tokens[8]));
			pension.setToilet(Integer.parseInt(tokens[9]));
			pension.setRoom(Integer.parseInt(tokens[10]));
			pension.setBreakfast(Integer.parseInt(tokens[11]));
			pension.setWifi(Integer.parseInt(tokens[12]));
			errormsg="에러메세지-";
			

			
		} catch (Exception e) {
			System.err.println(errormsg);
			e.printStackTrace();
		}
		return pension;
	}

	public static void main(String[] args) throws Exception {
		String target = "SONATA/3/50000/4/����/sonata.jpg/����������";
		RentPension x = RentPensionParsing.parsing(target);
		System.out.println(x);
		// �Ǵٸ� ��� ������(common tool) Parsing4Batch�� Ȱ�� 
		String[] setters = new String[] { 
				"setName", "setCategory", "setPrice", "setUsepeople", "setCompany", "setImg",
				"setInfo" };
		Parsing4Batch parser = new Parsing4Batch(RentPension.class, "/");
		RentPension y=(RentPension)parser.parsing(target, setters);
		System.out.println(y);
	}
}