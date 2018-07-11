/**
 * 
 * @author		
 */
package com.zzy.demo;

import java.util.HashMap;

/**
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * @author	
 * @date	
 * @version 
 */
public class BruteForce {
	public int indexOf_BF(String mainString, String t, int start){
		
		if(mainString != null && t != null && t.length() > 0 && mainString.length() > t.length()){
			int mlen = mainString.length();
			int tlen = t.length();
			int i = start;
			int j = 0;
			while((i < mlen) && (j < tlen)){
				if(mainString.charAt(i) == t.charAt(j)){
					i++;
					j++;
				}else{
					i = i - j + 1;
					j = 0;
				}
			}
			if(j >= t.length()){
				return i - tlen;
			}else{
				return -1;
			}
		}
		return -1;
	}
}
