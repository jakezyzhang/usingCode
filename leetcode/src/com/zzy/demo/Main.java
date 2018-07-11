package com.zzy.demo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int[][] runtime = new int[3][t];
		for(int i = 0; i < t; i ++){
			for(int j = 0; j < 3; j ++){
				runtime[j][i] = input.nextInt();
			}
		}
		method(t, runtime);
	}
	
	public static void method(int t, int[][] runtime){
		if(t == 0){
			System.out.println(0);
			return;
		}
		int[] result = new int[t];
		
		for(int i = 0; i < t; i ++){
			if(runtime[1][i] == 0){
				result[i] = 0;
			}else if(runtime[0][i] % runtime[1][i] == 0){
				result[i] = runtime[0][i] + (runtime[0][i] / runtime[1][i] - 1) * runtime[2][i];	
			}else{
				result[i] = runtime[0][i] + (runtime[0][i] / runtime[1][i]) * runtime[2][i];
			}
		}
		
		for(int i = 0; i < t; i ++){
			System.out.println(result[i]);
		}
	}
}
