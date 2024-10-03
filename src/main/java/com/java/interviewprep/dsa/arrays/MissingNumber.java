package com.java.interviewprep.dsa.arrays;

public class MissingNumber {
	
//	Given an array containing n-1 integers, which are in the range from 1 to n. Find the missing number.
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 5 , 4, 3, 8, 6, 9};
		int n = arr.length + 1;
		
		System.out.println("Missing number is :: " + findMissingNumber(arr, n));
	}
	
	public static int findMissingNumber(int [] array, int n) {
		
//		Calculate the sum of first n natural numbers
		int totalSum = n * (n + 1) / 2;
		
		int arraySum = 0;
		for(int num : array) {
			arraySum += num;
		}
		
//		Missing number is the difference between total array element sum and missing number array sum
		return totalSum - arraySum;
	}

}
