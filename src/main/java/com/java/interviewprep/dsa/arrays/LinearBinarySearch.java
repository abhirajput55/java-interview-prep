package com.java.interviewprep.dsa.arrays;

public class LinearBinarySearch {

	public static void main(String[] args) {
		
		int[] numbers = {5, 2, 8, 1, 3};
        int target = 8;
        linearSearch(numbers, target);
        
        int[] arr = {1, 2, 3, 5, 8};  // Sorted array
        int num = 5;
        binarySearch(arr, num);
	}

	private static void binarySearch(int[] arr, int num) {
		
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right) {
//			first divide an array and get middle index
			int mid = left + (right - left) / 2;
			
//			then compare our target with middle index element
			if(arr[mid] == num) {
				System.out.println("found at index :: " + mid);
				break;
			}
			
//			if our target element is greater or less than middle element 
//			then remove the respective part of that array by adjusting left and right
			if(arr[mid] < num) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}
		
	}

	private static void linearSearch(int[] numbers, int target) {
		
		for(int i=0; i<numbers.length-1; i++) {
			if(numbers[i] == target) {
				System.out.println("found at index :: " + i);
				break;
			}
		}
		
	}
}
