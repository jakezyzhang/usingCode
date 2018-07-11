package com.zzy.test;

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6};
		int target = 0;
		System.out.println(searchInsert(nums, target));
	}
	
	public static int searchInsert(int[] nums, int target) {
        
		int j = nums.length - 1;
		if(target>nums[j]){
			return nums.length;
		}
		
		for(;j>=1&&nums[j]>=target;j--){
			if(nums[j-1]<target){
				return j;
			}
		}
		return 0;
    }
}
