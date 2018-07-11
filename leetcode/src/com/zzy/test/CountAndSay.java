/**
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * @author	
 * @date	
 * @version 
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
public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}
	public static String countAndSay(int n) {
        String s = "1";
        StringBuilder sb = new StringBuilder();
        int num;
        char previous;
        for (int i = 1; i < n; i++) {
            num = 1;
            previous = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == previous) {
                    num++;
                } else {
                    sb.append(num).append(previous - 48);
                    previous = s.charAt(j);
                    num = 1;
                }
            }
            sb.append(num).append(previous - 48);
            s = sb.toString();
            sb.setLength(0);
        }
        return s;
    }
}
