/**
 * 
 * @author		
 */
package com.zzy.test;

import java.util.Arrays;

/**
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * @author	
 * @date	
 * @version 
 */
public class Sum3Closest {
	public static void main(String[] args) {
		int target = -100;
		int[] nums = {1, 1, 1, 0};
		System.out.println(threeSumClosest(nums, target));
	}
	public static int threeSumClosest(int[] nums, int target) {
        
		if(nums.length < 3 || nums == null){
        	return 0;
        }
		
		Arrays.sort(nums);
        int a, b, c;
        int sum = 0;
        int clo = nums[0] + nums[1] + nums[2];
        int len = nums.length;
       
        for( a = 0; a < len; a ++){
        	b = a + 1;
        	c = len - 1;
        	while (b < c) {
        		sum = nums[a] + nums[b] + nums[c];
        		clo = Math.abs(clo - target) < Math.abs(sum - target) ? clo : sum;
        		if(sum == target){
        			return target;
        		}else if(sum < target){
        			b ++;
        		}else{
        			c--;
        		}
			}       	
        }
        
        
        return clo;
    }
}
