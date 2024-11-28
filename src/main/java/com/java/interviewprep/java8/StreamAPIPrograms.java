package com.java.interviewprep.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIPrograms {
	
//	https://github.com/rohitchavan-git/Java-8-Interview-Sample-Coding-Questions
	
	public static void main(String[] args) {
//		1. Separate odd and even numbers in a list of integers
		separateOddEven(List.of(12, 5, 3, 78, 42, 9, 34, 56, 1));
		
//		2. Remove duplicate elements from a list using Java 8 streams
		removeDuplicates(List.of(3, 7, 12, 3, 5, 7, 8, 12, 5, 9));
		
//		3. Find the frequency of each character in a string using Java 8 streams
		frequency("programming");
		
//		4. Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
		joinList(List.of("apple","banana","cherry","grape","orange","pineapple"));
		
//		5. Find the maximum and minimum of a list of integers
		findMinMaxNum(List.of(12, 5, 3, 78, 42, 9, 34, 56, 1));
		
//		6. Merge two unsorted arrays into a single sorted array using Java 8 streams
		int[] arr1 = {12, 5, 3, 78, 42, 34, 56};
		int[] arr2 = {32, 53, 25, 7, 8, 9};
		mergeArray(arr1, arr2);
	}


	private static void mergeArray(int[] arr1, int[] arr2) {
		
		int[] result = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
		
		for(int i : result) {
			System.out.print(i);
			System.out.print(" ");
		}
	}


	private static void findMinMaxNum(List<Integer> list) {
		
		Comparator<Integer> sort = (a, b) -> {
			if(a > b) {
				return 1;
			}else if(a < b) {
				return -1;
			}else {
				return 0;
			}
		};
		
		Integer min = list.stream().min(sort).get();
		
		System.out.println("min :: " + min);
		
		Integer max = list.stream().max(sort).get();
		
		System.out.println("max :: " + max);
	}


	private static void joinList(List<String> list) {
		String string = list.stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println(string);
	}


	private static void frequency(String string) {

		Map<Character, Long> collect = string.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
	}

	private static void removeDuplicates(List<Integer> list) {
		List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void separateOddEven(List<Integer> list) {
		Predicate<Integer> isEven = e -> e%2==0;
		List<Integer> evenList = list.stream().filter(isEven).collect(Collectors.toList());
		List<Integer> oddList = list.stream().filter(isEven.negate()).collect(Collectors.toList());
		System.out.println("even :: " + evenList);
		System.out.println("odd :: " + oddList);
	}
	
	

}
