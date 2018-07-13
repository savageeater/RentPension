package com.lhs.pension.common;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lhs.pension.dto.PMember;
import com.lhs.pension.dto.RentPension;

public class Parsing4Batch {
	private Class clazz;
	private String regex;

	public Parsing4Batch(Class clazz, String regex) {
		this.clazz = clazz;
		this.regex = regex;
	}

	public Object parsing(String target, String... settersName) throws Exception {
		String[] tokens = target.split(regex);
		Object obj = null;
		// -------------------------------------
		// ������ ���⿡�� ��������� �迭������ ������ �� ����
		// ��ū���� ������ ���� �ʴٴµ� �ִ�. �̸� �ذ��ؾ� �Ѵ�.
		Method[] methods = clazz.getMethods();
		obj = clazz.newInstance();
		List<Method> setters = new ArrayList<>();
		for (int i = 0; i < methods.length; i++) {
			if (!methods[i].getName().startsWith("set"))
				continue;
			setters.add(methods[i]);
		}
		// ��ū�� ������ �´� ���͸� �ҷ� ����
		for (int i = 0; i < tokens.length; i++) {
			String setterName = settersName[i];
			String paraType = "";
			for (Method x : setters) {
				if (x.getName().equals(setterName)) {
					Class<?>[] p = x.getParameterTypes();
					paraType = (p[0].getSimpleName());
					Method y = null;
					switch (paraType) {
					case "int":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, Integer.parseInt(tokens[i]));
						break;
					case "String":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, tokens[i]);
						break;
					case "long":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, Long.parseLong(tokens[i]));
						break;
					// .........�ʿ��ϸ� �ø�����
					}
				}
			}
		}
		return obj;
	}

	// ����
	public static void main(String[] args) throws Exception {
		Parsing4Batch parser = new Parsing4Batch(RentPension.class, "/");
		String[] setters1 = new String[] { 
				"setName", "setCategory", "setPrice", "setUsepeople", "setCompany", "setImg",
				"setInfo" };
		RentPension x = (RentPension) parser.parsing("SONATA/3/50000/4/����/sonata.jpg/����������", setters1);
		System.out.println(x);
		// ---------------------------------------------------------
		Parsing4Batch parser2 = new Parsing4Batch(PMember.class, "/");
		String[] setters2 = new String[] { "setId", "setPass", "setEmail", "setTel", "setAge", "setJob", "setHobby" };
		PMember mem = (PMember) parser2.parsing("sjw/1234/jaain@naver.com/010-2307-3558/60��/����/���", setters2);
		System.out.println(mem);
	}
}