package com.java.interviewprep.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Top10JavaPrograms {

	public static void main(String[] args) {
		
//		Write a program to reverse a given string.
		reverseString("Abhishek");
		
//		Check whether a string is a palindrome.
		checkPalindrome("oppo");
		
//		Given an array of integers, find the duplicate numbers.
		int[] nums = {1, 2, 3, 2, 4, 5, 5};
		findDuplicatesInArray(nums);
		
//		Write a function to compute the Nth Fibonacci number.
		fibonacciNumber(9);
		
//		Given an array of integers, return indices of the two numbers such that they add up to a specific target.
		int[] numsArray = {2, 7, 11, 15};
        int target = 22;
        twoSum(numsArray, target);
        
//      Implement an algorithm to determine if a string has all unique characters.
        checkUniqueChars("asdfghjk");
        
//      Rotate an array to the right by k steps, where k is non-negative.
        rotateArray(numsArray, 4);
        
        
	}
	
	
	private static void rotateArray(int[] nums, int k) {
		
		for(int i=1; i<=k; i++) {
			int second = nums[nums.length-1];
			for(int j=0; j<nums.length; j++) {
				int temp = nums[j];
				nums[j] = second;
				second = temp;
			}
			
		}
		
		for(int i : nums) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	private static boolean checkUniqueChars(String string) {
		Set<Character> set = new HashSet<>();
		char[] chars = string.toCharArray();
		for(char c : chars) {
			if(!set.add(c)) {
				System.out.println(true);
				return true;
			}
		}
		System.out.println(true);
		return false;
	}

	private static void twoSum(int[] nums, int target) {
		
		for(int i=0; i < nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target)
					System.out.println("Indices :: " + i + ", " + j);
			}
		}
		
	}

	private static int fibonacciNumber(int n) {
		if(n <= 1) {
			System.out.println(n);
			return n;
		}
		
		int a = 0, b = 1;
		
		for(int i=2; i<=n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		
		System.out.println(b);
		return b;
	}

	private static void findDuplicatesInArray(int[] nums) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int i : nums) {
			if(!set.add(i))
				System.out.println(i);
		}
	}

	private static void checkPalindrome(String string) {
		
		if(string.equals(reverseString(string)))
			System.out.println(true);
		else
			System.out.println(false);
		
	}

	private static String reverseString(String string) {
		StringBuilder sb = new StringBuilder();
		for(int i=string.length()-1; i>=0; i--) {
			sb.append(string.charAt(i));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
