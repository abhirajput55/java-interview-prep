package com.java.interviewprep.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

	public static void main(String[] args) {
		
		String s1 = "cdd";
		String s2 = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s1));
	}
	
	
	public static int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int max = 0;
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                i = map.get(arr[i]);
                if(map.size() > max)
                    max = map.size();
      
                map = new HashMap<>();
            }else{
                map.put(arr[i], i);
            }
        }

        if(map.size() > max)
            max = map.size();

        return max;
    }
}
