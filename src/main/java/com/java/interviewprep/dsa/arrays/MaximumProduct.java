package com.java.interviewprep.dsa.arrays;

public class MaximumProduct {
	
//	Given an array of integers, find the two numbers that, when multiplied together, give the maximum product.
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 5 , 4, 3, 8, 6, 9};
		System.out.println("Maximum product is :: " + findMaximumProduct(arr));
	}


	private static int findMaximumProduct(int[] arr) {
		
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for(int num : arr) {
			if(num > max1) {
				max2 = max1;
				max1 = num;
			}else if(num > max2) {
				max2 = num;
			}
		}
		return max1 * max2;
	}

}
