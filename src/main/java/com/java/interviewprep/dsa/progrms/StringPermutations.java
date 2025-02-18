package com.java.interviewprep.dsa.progrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class StringPermutations {

//	Java Program to Find all Permutations of String
	
	public static void main(String[] args) {
		
		String str = "ABC";
		
		backTrack(str, 0, str.length()-1);
		
	}

	public static void backTrack(String str, int idx, int n) {
		
		if(idx == n) {
			System.out.println(str);
		}else {
			for(int i=idx; i<=n; i++) {
				str = swap(str, idx, i);
				backTrack(str, idx+1, n);
				str = swap(str, idx, i);
			}
		}
	}
	
	public static String swap(String str, int i, int j) {
		
		char[] charArray = str.toCharArray();
		
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		
		return String.valueOf(charArray);
	}
	
}
