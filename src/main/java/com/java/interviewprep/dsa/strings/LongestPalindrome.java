package com.java.interviewprep.dsa.strings;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		
		String s1 = "cbbd";
		String s2 = "ac";
		System.out.println(longestPalindrome(s1));
	}

	
	public static String longestPalindrome(String s) {
		
//		if(isPalindrome(s)){
//            return s;
//        }
		
        int left = 0;
        int right = 1;
        for(int i=0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
            	String substring = s.substring(i, j+1);
            	boolean palindrome = isPalindrome(s.substring(i, j+1));
            	String substring2 = s.substring(left, right);
            	
                if(isPalindrome(s.substring(i, j+1)) && s.substring(i, j+1).length() > s.substring(left, right).length()){
                    left = i;
                    right = j+1;
                }
            }
        }
        
        return s.substring(left, right);
    }

    private static boolean isPalindrome(String s){
        boolean flag = true;
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }
}
