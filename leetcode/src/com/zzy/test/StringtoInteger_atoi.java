package com.zzy.test;

import java.util.Scanner;

public class StringtoInteger_atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		StringtoInteger_atoi stringto = new StringtoInteger_atoi();
		System.out.println(stringto.myAtoi(str));
	}
	public int myAtoi(String str) {
		str.trim();
		int arr = 0;
		StringBuilder strB = new StringBuilder();
		if((str.charAt(0)>90&&str.charAt(0)<97)||str.charAt(0)<65||str.charAt(0)>122){
			return 0;
		}
		for(int i = 0; i < str.length(); i ++){
			arr = str.charAt(i);
			strB.append(arr);
		}
		String str2 = strB.toString();
		if(str2.length()>=10){
			return 0;
		}
		int n = Integer.parseInt(str2);
		if(n>Integer.MAX_VALUE){
			return 0;
		}else if(n<Integer.MIN_VALUE){
			return 0;
		}
		return n;
    }

}
