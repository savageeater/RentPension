package com.lhs.pension.common;

import com.lhs.pension.dto.RentPension;

public class RentPensionParsing {
	public static RentPension parsing(String target) throws Exception{
		//"0/SONATA/3/50000/4/����/sonata.jpg/����������"
		String[] tokens = target.split("/");
		RentPension car = new RentPension();
		String errormsg="";
		try {
			car.setNo(0);
			car.setName(tokens[0]);
			errormsg="ī�װ���ȣ�� 1,2,3�̾�� �Ѵ�.";

			errormsg="�����뿩�� �κ� �����̾�� �մϴ�.";
			car.setPrice(Integer.parseInt(tokens[2]));
			errormsg="ž���ڼ� �κ� �����̾�� �մϴ�.";

			car.setImg(tokens[5]);
			car.setInfo(tokens[6]);
		} catch (Exception e) {
			System.err.println(errormsg);
			e.printStackTrace();
		}
		return car;
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