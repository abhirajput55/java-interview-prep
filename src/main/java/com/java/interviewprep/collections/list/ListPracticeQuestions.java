package com.java.interviewprep.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ListPracticeQuestions {

	public static void main(String[] args) {
		
		List<Integer> duplicateNumList = new ArrayList<>(Arrays.asList(2, 4, 5, 1, 2, 6, 5 , 7, 4, 2, 7, 9, 8));
		List<Integer> sortedListList1 = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9));
		List<Integer> sortedListList2 = new ArrayList<>(Arrays.asList(3, 10, 11, 12));
		List<String> duplicateWordList = new ArrayList<>(Arrays.asList("Java", "CPP", "Python", "CPP", "Java", "CPP", "Java"));
		
		
//		Write a program to remove duplicates from an ArrayList of integers without using Set.
//		removeDuplicatesWithoutSet(duplicateNumList);
		
//		Implement a function that merges two sorted lists of integers into a single sorted list.
//		mergeSortedListIntoSortedList(sortedListList1, sortedListList2);
		
//		Given an ArrayList of words, find and print the most frequently occurring word.
//		findMostOccuringWord(duplicateWordList);
		
//		Write a method to reverse an ArrayList without using in-built reverse functions.
		reverseList(sortedListList1);
		
	}

	private static void removeDuplicatesWithoutSet(List<Integer> duplicateNumList) {
		
		Collections.sort(duplicateNumList);
		int i = 0;
		while(i < duplicateNumList.size()) {
			if(i != duplicateNumList.size()-1 && duplicateNumList.get(i).equals(duplicateNumList.get(i+1))) {
				duplicateNumList.remove(i);
			}else {
				i++;
			}
		}
		
		System.out.println(duplicateNumList);
	}
	
	private static void mergeSortedListIntoSortedList(List<Integer> sortedListList1, List<Integer> sortedListList2) {
		
		sortedListList1.addAll(sortedListList2);
		Collections.sort(sortedListList1);
		System.out.println(sortedListList1);
		
	}
	
	private static void findMostOccuringWord(List<String> duplicateWordList) {
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		for(int i=0; i<duplicateWordList.size(); i++) {
			if(!map.containsKey(duplicateWordList.get(i))) {
				map.put(duplicateWordList.get(i), 1);
			}else {
				map.put(duplicateWordList.get(i), map.get(duplicateWordList.get(i)) + 1);
			}
			
			if(max < map.get(duplicateWordList.get(i)))
				max = map.get(duplicateWordList.get(i));
		}
		
		for(Entry<String, Integer> e : map.entrySet()) {
			if(max == e.getValue()) {
				System.out.println(e.getKey());
			}
		}
	}
	
	private static void reverseList(List<Integer> sortedListList1) {
		List<Integer> list = new ArrayList<>();
		for(int i=sortedListList1.size()-1; i >= 0; i--) {
			list.add(sortedListList1.get(i));
		}
		System.out.println(list);
	}

}
