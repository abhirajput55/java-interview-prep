package com.java.interviewprep.dsa.progrms;

public class PalindromeString {

//	Write a Java program to check if a given string is a palindrome
	
	public static void main(String[] args) {
		
		 String input = "level";
		 
		 int left = 0;
		 int right = input.length()-1;
		 boolean flag = true;
		 while(left < right) {
			 if(input.charAt(left) != input.charAt(right)) {
				 flag = false;
				 break;
			 }
			 left++;
			 right--;
		 }
		 
		 System.out.println(flag);
	}
}
