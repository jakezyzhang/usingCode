/**
 * 
 * @author		
 */
package com.zzy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * @author	
 * @date	
 * @version 
 */
public class Sum3 {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> list = threeSum(nums);
		for(int i = 0; i < list.size(); i ++){
			System.out.println(list.get(i));
		}
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<>();
		
		if( nums.length < 3 || nums == null ){
			return res;
		}
		Arrays.sort(nums);
		int len = nums.length;
		int a,b,c;
		int sum = 0;
		for(a = 0; a < len; a ++){
			
			if(a > 0 &&  nums[a - 1] == nums[a] ){
				continue;
			}
			
			b = a + 1;
			c = len - 1;
			while(b < c){
				sum = nums[a] + nums[b] + nums[c];
				if(sum > 0){
					c--;
				}else if(sum < 0){
					b++;
				}else{
					List<Integer> items = new ArrayList<>();
					items.add(nums[a]);
					items.add(nums[b]);
					items.add(nums[c]);
					res.add(items);
					
					while((b += 1) < c && nums[b] == nums[b - 1]){
						continue;
					}
					while((c -= 1) > b && nums[c] == nums[c + 1]){
						continue;
					}
				}
			}
		}
		return res;
	}
}
