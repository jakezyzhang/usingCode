package com.zzy.test;

import java.util.Scanner;

public class ReverseInteger {
	public static void main(String[] args) {
		
	}
	
	public static int reverse(int x) {
		String strX = x + "";
		String sign = null;
		StringBuilder strb = new StringBuilder();
		StringBuilder strb2 = new StringBuilder();
		if(strX.length()>23){
			return 0;
		}else{
			if(strX.charAt(0)=='-'){
				sign = "-";
				strb.append(sign);
				strb2.append(strX.substring(1, strX.length()));
				strb2.reverse();
				strb.append(strb2);
			}else{
				strb.append(strX);
				strb.reverse();
			}
			
		}
		int result = Integer.parseInt(strb.toString());
		
		return result;
    }
}
