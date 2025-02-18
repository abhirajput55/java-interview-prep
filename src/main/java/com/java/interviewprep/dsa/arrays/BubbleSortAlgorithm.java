package com.java.interviewprep.dsa.arrays;

public class BubbleSortAlgorithm {
	
	public static void main(String[] args) {
		
//		Sort an array of ages in descending order.
//		You are given a list of ages, and you need to sort them in descending order using Bubble Sort.
		int[] inputArray = {25, 18, 30, 22, 27};
//		Expected Output:[30, 27, 25, 22, 18]
		
//		sortAgesDesc(inputArray);
		
		
//		Sort a list of names alphabetically (in ascending order).
//		You are given a list of names and need to sort them in alphabetical order using Bubble Sort.
		String[] arr = {"John", "Alice", "Bob", "Eve"};
//		Expected Output:["Alice", "Bob", "Eve", "John"]
		
//		sortNameAsc(arr);	
		
		int[] nums = {3,2,1,5,6,4}; 
		int k = 2;
		int element = findKthLargest(nums, k);
		System.out.println(element);
	}
	
	public static int findKthLargest(int[] nums, int k) {
        
        // Bubble Sort Approach

        int temp = 0;
        boolean swapped = false;

        for(int i=0; i<k; i++){
            for(int j=0; j<nums.length-1-i; j++){
                if(nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

        return nums[nums.length - k];
    }

	private static void sortAgesDesc(int[] arr) {
		
		for(int i=0; i < arr.length; i++) {
			
			for(int j=0; j < arr.length-1; j++) {
				
				if(arr[j] < arr[j+1]) {
					// Swap the elements
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	
	private static void sortNameAsc(String[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=0; j<arr.length-1; j++) {
				
				if(arr[j].compareTo(arr[j+1]) > 0) {
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(String i : arr) {
			System.out.println(i);
		}
	}
	

}
