package com.zzy.test;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPalindrome(int x) {
		if(x<0 || (x % 10 == 0 && x != 0)){
			return false;
		}
		
		int  reveredNumber = 0;
		while(x > reveredNumber){
			reveredNumber = reveredNumber * 10 + x % 10;
			x /= 10;
		}
		
		return x==reveredNumber||x==reveredNumber/10;
    }
}
