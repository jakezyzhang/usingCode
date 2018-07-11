/**
 * 
 * @author		
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
public class ContainerWithMostWater {
	 public int maxArea(int[] height) {
		 int minh = 0;
		 int maxArea = height[0];
	
		 for(int i = 0; i < height.length; i ++){
			 minh = height[i];
			 for(int j = i + 1; j < height.length; j ++){
				 minh = Math.min(minh, height[j]);
				 maxArea = Math.max(maxArea, (j - i + 1) * minh);
			 }
		 }
		 
		 return maxArea;
	 }
}
