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
public class ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 4;
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert(s, numRows));
	}
	public String convert(String s, int numRows) {
        
		StringBuilder sb = new StringBuilder();
		
		int num = s.length();
        int line = num / ( numRows + (numRows - 2) );
        int next = numRows + (numRows - 2);
        sb.append(s.charAt(0));
        int sum = 2;
		//int enter = numRows - 2;
        int i = 0;
        for(;i < numRows; i ++){
        	if(i==0){
        		for(int j = 1;j <= line; j ++){
        			sb.append(s.charAt(next));
        			next = next * (j + 1);
        		}
        
        	}else{

        		for(int j = 1; j < line; j ++){
        			sum =  sum  + numRows + (numRows - 2);
        			sb.append(s.charAt(sum));
        		}
        	}
        }
        
		return sb.toString();
    }
}
