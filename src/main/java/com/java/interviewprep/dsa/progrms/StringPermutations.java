package com.java.interviewprep.dsa.progrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringPermutations {

//	Java Program to Find all Permutations of String
	
	public static void main(String[] args) {
		
		String str = "ABC";
		
		List<String> list = findAllPermutation(str);
		System.out.println(list);
	}

	private static List<String> findAllPermutation(String str) {
		findPermutation(str, "");
		return null;
	}
	
	private static void findPermutation(String str, String prefix) {
		
//		if(prefix.length() == )
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			String remaining = str.substring(0, i) + str.substring(i + 1);
			
			findPermutation(remaining, prefix+ch);
		}
	}
}
