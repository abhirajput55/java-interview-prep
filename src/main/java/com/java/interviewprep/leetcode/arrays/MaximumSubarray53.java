package com.java.interviewprep.leetcode.arrays;

import java.util.Arrays;
import java.util.List;

public class MaximumSubarray53 {
	
	public static void main(String[] args) {
		
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
	}
	
//	Kadane’s Algorithm
	public static int maxSubArray(int[] nums) {
        int maxEndHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            maxEndHere += nums[i];

            if(maxSoFar < maxEndHere){
                maxSoFar = maxEndHere;
            }

            if(maxEndHere < 0){
                maxEndHere = 0;
            }
        }

        return maxSoFar;
    }

}
