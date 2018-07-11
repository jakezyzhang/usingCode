package com.zzy.test;

public class ImplementstrStr {
	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "";
		System.out.println(strStr(haystack, needle));
	}
	
	public static int strStr(String haystack, String needle) {
		if(needle.equals("")){
			return 0;
		}
        return haystack.indexOf(needle);
    }
}
