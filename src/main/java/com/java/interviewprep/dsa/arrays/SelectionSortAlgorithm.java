package com.java.interviewprep.dsa.arrays;

public class SelectionSortAlgorithm {
	
	public static void main(String[] args) {
		
		
//	Given an array of integers nums, sort the array in ascending order and return it.
//	You must solve the problem without using any built-in functions in O(nlog(n)) 
//	time complexity and with the smallest space complexity possible.
	
		int[] nums = {5,2,3,1};
		sortArray(nums);
	
	}

	public static void sortArray(int[] nums) {
        
        // Selection Sort Approach

        int temp = 0;
        int minIndex = -1;

        for(int i=0; i<nums.length-1; i++){
            minIndex = i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[minIndex] > nums[j])
                    minIndex = j;
            }

            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        
        for(int i : nums){
            System.out.print(i + " ");
        }
        
    }
}
