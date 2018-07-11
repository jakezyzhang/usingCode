package com.zzy.test;

import java.util.Scanner;

public class RomantoInteger {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println(romanToInt(s));
		input.close();
	}
	
	public static int romanToInt(String s) {
		int count = 0;
		int i = 0;
		for(i = 1; i < s.length(); i ++){
        	if(s.charAt(i-1)=='I'){
        		if(s.charAt(i)=='V'){
        			count += 4;
        			++i;
        		}else if(s.charAt(i)=='X'){
        			count += 9;
        			++i;
        		}else{
        			count += 1;
        		}
        	}else if(s.charAt(i-1)=='V'){
        		count += 5;
        	}else if(s.charAt(i-1)=='X'){
        		if(s.charAt(i)=='L'){
        			count += 40;
        			++i;
        		}else if(s.charAt(i)=='C'){
        			count += 90;
        			++i;
        		}else{
        			count += 10;
        		}
        	}else if(s.charAt(i-1)=='L'){
        		count += 50;
        	}else if(s.charAt(i-1)=='C'){
        		if(s.charAt(i)=='D'){
        			count += 400;
        			++i;
        		}else if(s.charAt(i)=='M'){
        			count += 900;
        			++i;
        		}else{
        			count += 100;
        		}
        	}else if(s.charAt(i-1)=='D'){
        		count += 500;
        	}else if(s.charAt(i-1)=='M'){
        		count += 1000;
        	}
        		
        	
        }
		if(i==s.length()){
			if(s.charAt(i-1)=='I'){
				count += 1;
			}else if(s.charAt(i-1)=='V'){
				count += 5;
			}else if(s.charAt(i-1)=='X'){
				count += 10;
			}else if(s.charAt(i-1)=='L'){
				count += 50;
			}else if(s.charAt(i-1)=='C'){
				count += 100;
			}else if(s.charAt(i-1)=='D'){
				count += 500;
			}else if(s.charAt(i-1)=='M'){
				count += 1000;
			}
		}
		return count;
    }
}
