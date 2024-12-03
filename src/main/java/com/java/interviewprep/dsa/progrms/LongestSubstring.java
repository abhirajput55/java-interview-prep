package com.java.interviewprep.dsa.progrms;

public class LongestSubstring {

//	Write a Java program to find the longest substring without repeating characters
	
	public static void main(String[] args) {
		
        String input = "abcdcbcdbbcdef";
        String s = "dvdf";
        String blank = "";
        String str = findLongestSubstring(blank);
        System.out.println("Longest substring without repeating characters: " + str);
    }

	private static String findLongestSubstring(String input) {
		
		if(input.isEmpty())
			return "";
		
		int left = 0;
		int right = 0;
		int k = 0;
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<input.length(); i++) {
			
			if(!builder.toString().contains(input.charAt(i) + "")) {
				builder.append(input.charAt(i));
			}else {
				
				if(input.substring(left, right).length() < builder.length()) {
					left = k;
					right = i-1;
				}
				
				i = input.lastIndexOf(input.charAt(i), i-1);
				k = i + 1;
				builder = new StringBuilder();
			}
		}
		
		if(input.substring(left, right).length() < builder.length()) {
			left = k;
			right = input.length()-1;
		}
		return input.substring(left, right+1);
	}	
}
