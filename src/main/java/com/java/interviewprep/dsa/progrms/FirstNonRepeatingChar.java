package com.java.interviewprep.dsa.progrms;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		
		String str = "abcbda";
		
		LinkedHashMap<Character, Integer> map = findOccurence(str);
		
		for(Entry<Character, Integer> e : map.entrySet()) {
			if(e.getValue() == 1) {
				System.out.println(e.getKey());
				break;
			}
		}
	}

	
	private static LinkedHashMap<Character, Integer> findOccurence(String str) {
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		
		return map;
	}
}
