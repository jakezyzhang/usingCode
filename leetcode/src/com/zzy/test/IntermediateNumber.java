package com.zzy.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IntermediateNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double intermidiate = 0;
        int a = 0,b = 0;
        int i = 0, j = 0;
        boolean flag = true;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<Integer>();
        while(flag){
			if(i < nums1.length&&j < nums2.length){
				if(nums1[i] > nums2[j]){
					list.add(nums2[j]);
					j++;
				}else if(nums1[i] == nums2[j]){
					list.add(nums1[i]);
					list.add(nums2[j]);
					i++;
					j++;
				}else{
					list.add(nums2[i]);
					i++;
				}
			}
			if(i==nums1.length&&j==nums2.length){
				flag = false;
			}
       	}
		if((j+i)%2==0){
			a = (j+i) / 2 - 1;
			b = (j+i+2) / 2 -1;
			intermidiate = (list.get(a) + list.get(b)) / 2;
		}else if((j+i)%2!=0){
			a = (j+i+1) / 2;
			intermidiate = list.get(a);
		}
		
		return intermidiate;
    }
}
