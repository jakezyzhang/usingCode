/**
 * 
 * @author		
 */
package com.zzy.test;

/**
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * @author	
 * @date	
 * @version 
 */
public class IntegertoRoman {
	public static void main(String[] args) {
		int num = 50;
		System.out.println(intToRoman(num));
	}
	
	public static String intToRoman(int num) {
//		String numStr = num + "";
		StringBuilder sb = new StringBuilder();
		
			//计算千位的
			for(int i = 0; i < num/1000; i ++){
				sb.append("M");
			}
			//计算百位的
			int han = num - (num / 1000 * 1000);
			if(han / 100 == 9){
				sb.append("CM");
			}else if(han / 100 == 4){
				sb.append("CD");
			}else {
				if(han < 500){
					for(int i = 0; i < han / 100; i ++){
						sb.append("C");
					}
				}else if(han > 500){
					sb.append("D");
					for(int i = 0; i < (han-500) / 100; i ++){
						sb.append("C");
					}
				}else if(han == 500){
					sb.append("D");
				}
			}
			//计算十位的
			int ten = (num - (num / 1000 * 1000)) - ((num - (num / 1000 * 1000)) / 100 * 100);
			
			if(ten / 10 == 9){
				sb.append("XC");
			}else if(ten / 10 == 4){
				sb.append("XL");
			}else {
				if(ten < 50){
					for(int i = 0; i < ten / 10; i ++){
						sb.append("X");
					}
				}else if(ten > 50){
					sb.append("L");
					for(int i = 0; i < (ten-50) / 10; i ++){
						sb.append("X");
					}
				}else if(ten == 50){
					sb.append("L");
				}
			}
			
			//计算各位
			int ge = ((num - (num / 1000 * 1000)) - ((num - (num / 1000 * 1000)) / 100 * 100)) - ((num - (num / 1000 * 1000)) - ((num - (num / 1000 * 1000)) / 100 * 100)) / 10 * 10;
			
			if(ge == 9){
				sb.append("IX");
			}else if(ge == 4){
				sb.append("IV");
			}else {
				if(ge < 5){
					for(int i = 0; i < ge; i ++){
						sb.append("I");
					}
				}else if(ge > 5){
					sb.append("V");
					for(int i = 0; i < ge - 5; i ++){
						sb.append("I");
					}
				}else if(ge == 5){
					sb.append("V");
				}
			}
			
		return sb.toString();
	}
}
