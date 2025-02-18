package com.java.interviewprep.dsa.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class InsertionSortAlgorithm {
	
	public static void main(String[] args) {
		
//		Leetcode : 506. Relative Ranks
		int[] score = {10,3,8,9,4};
//		Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
		
		for(String s : findRelativeRanks(score)) {
			System.out.print(s + " ");
		}
	}
	
	public static String[] findRelativeRanks(int[] score) {
        
        // Insertion Sort Approach
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] arr = Arrays.copyOf(score, score.length);
        String[] answer = new String[score.length];
        for(int i=1; i<score.length; i++){
            int temp = score[i];
            int j = i - 1;
            map.put(arr[j], j);
            while(j >= 0 && score[j] < temp){
                score[j+1] = score[j];
                j--;
            }
            score[j+1] = temp;
        }
        map.put(arr[score.length-1], score.length-1);
        
        answer[map.get(score[0])] = "Gold Medal";
        answer[map.get(score[1])] = "Silver Medal";
        answer[map.get(score[2])] = "Bronze Medal";
        for(int i=3; i<score.length; i++){
        	answer[map.get(score[i])] = (i+1) + "";
        }
        return answer;
    }

}
