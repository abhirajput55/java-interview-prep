package com.java.interviewprep.dsa.progrms;

public class FindMissingNumberInArray {

//	Write a Java program to find the missing number in an array of integers from 1 to n
	
	public static void main(String[] args) {
		
		int[] nums = {1, 2, 4, 6, 3, 7, 8};
        int n = 8;
        
//      First calculate the sum of all numbers from 1 to n.
        int totalSum = n * (n + 1) / 2;
        
        int actualSum = 0;
        
//      Then calculate the sum of all elements from given array
        for(int i : nums) {
        	actualSum += i;
        }
        
        System.out.println(totalSum - actualSum);
	}
}
