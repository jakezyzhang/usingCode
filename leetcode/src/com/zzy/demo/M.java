package com.zzy.demo;

import java.util.HashMap;

public class M {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map = new HashMap<>();
		String str = "hello";
		String str2 = "he" + new String("llo");
		System.out.println(str == str2);
		System.out.println(str.equals(str2));
	
	}

}
