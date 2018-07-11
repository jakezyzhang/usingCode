package alibaba;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] yo = new int[m][2];
       
        for(int i = 0; i < 2; i ++){
        	for(int j = 0; j < m; j ++){
        		yo[j][i] = input.nextInt();
        	}
        }
        
    	Map<Integer, Integer> map = new HashMap<>();
        
    	for(int i = 1; i < n * 2; i ++){
    		map.put(i, i+1);
    	}
    	 for(int i = 0; i < 2; i ++){
         	for(int j = 0; j < m; j ++){
         		if(map.containsKey(yo[j][i]) && map.containsValue(yo[j][i])){
         			System.out.println("no");
         		}else {
         			System.out.println("yes");
         		}
         	}
         }
    	
    }
}
