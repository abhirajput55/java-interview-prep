package com.java.interviewprep.collections.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPracticeQuestions {
	
	public static void main(String[] args) {
		
		Set<Integer> numSet1 = new HashSet<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9));
		Set<Integer> numSet2 = new HashSet<>(Arrays.asList(9, 6, 4, 2, 11, 10, 5, 3));
		
		Set<String> wordSet1 = new HashSet<>(Arrays.asList("C", "CPP", "Java"));
		Set<String> wordSet2 = new HashSet<>(Arrays.asList("Java", "CPP", "Python", "C", "JavaScript"));
		
		List<Integer> dulicateNumList = new ArrayList<>(Arrays.asList(2, 4, 5, 1, 2, 6, 5 , 7, 4, 2, 7, 9, 8));
		
//		Write a program to find the union and intersection of two HashSets.
		findUnionOfTwoSets(numSet1, numSet2);
		
//		Implement a method to check if a HashSet of strings is a subset of another HashSet.
		checkForSubset(wordSet1, wordSet2);
		
//		Write code to remove all elements from a TreeSet that are greater than a specified element.
		removeAllGreaterThan(10, numSet2);
		
//		Given an array of integers, find and print the first non-repeated element using LinkedHashSet.
		findFirstNonRepeatedElement(dulicateNumList);
		
	}

	private static void findUnionOfTwoSets(Set<Integer> numSet1, Set<Integer> numSet2) {
		
		Set<Integer> unionset = new HashSet<>();
		unionset.addAll(numSet1);
		unionset.addAll(numSet2);		
		System.out.println(unionset);
		
		Set<Integer> intersectionset = new HashSet<>();
		intersectionset.addAll(numSet1);
		intersectionset.retainAll(numSet2);
		System.out.println(intersectionset);
	}
	
	private static void checkForSubset(Set<String> wordSet1, Set<String> wordSet2) {
		
		boolean containsAll = wordSet2.containsAll(wordSet1);
		System.out.println(containsAll);
	}
	
	private static void removeAllGreaterThan(int i, Set<Integer> numSet2) {
		
		TreeSet<Integer> numSet = new TreeSet<>(numSet2);
		NavigableSet<Integer> headSet = numSet.headSet(i, true);
		System.out.println(headSet);
		
	}
	
	private static void findFirstNonRepeatedElement(List<Integer> dulicateNumList) {
		
		LinkedHashSet<Integer> seeOnce = new LinkedHashSet<>();
		LinkedHashSet<Integer> seeMoreThanOnce = new LinkedHashSet<>();
		
		dulicateNumList.forEach(e -> {
			if(seeOnce.contains(e)) {
				seeMoreThanOnce.add(e);
				seeOnce.remove(e);
			}else {
				seeOnce.add(e);
			}
		});
		
		for(Integer e : seeOnce) {
			System.out.println(e);
			break;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
