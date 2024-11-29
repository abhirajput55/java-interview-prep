package com.java.interviewprep.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIPrograms {
	
//	https://github.com/rohitchavan-git/Java-8-Interview-Sample-Coding-Questions
	
	public static void main(String[] args) {
		
		List<String> stringList = List.of("apple","banana","cherry","grape","orange","pineapple");
		List<Integer> numList = List.of(12, 5, 3, 78, 42, 9, 34, 56, 1);
		List<Integer> duplicateList = List.of(3, 7, 12, 3, 5, 7, 8, 12, 5, 9);
		Integer[] arr1 = {12, 5, 3, 78, 42, 34, 56};
		Integer[] arr2 = {32, 53, 25, 7, 3, 8, 9};
		
//		1. Separate odd and even numbers in a list of integers
		separateOddEven(numList);
		
//		2. Remove duplicate elements from a list using Java 8 streams
		removeDuplicates(duplicateList);
		
//		3. Find the frequency of each character in a string using Java 8 streams
		frequency("programming");
		
//		4. Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
		joinList(stringList);
		
//		5. Find the maximum and minimum of a list of integers
		findMinMaxNum(numList);
		
//		6. Merge two unsorted arrays into a single sorted array using Java 8 streams
		mergeArray(arr1, arr2);
		
//		7. Get the three maximum and three minimum numbers from a given list of integers
		findThreeMinMaxNum(numList);
		
//		8. Check if two strings are anagrams or not using Java 8 streams
		checkAnagrams("listen", "silent");
		
//		9. Find the sum and average of all digits of a number/array in Java 8
		findSumAndAvarage(numList);
		
//		10. Find the second largest number in an integer array
		findSecondLargestNum(arr1);
		
//		11. Sort a list of strings according to the increasing order of their length
		sortByStringLength(stringList);
		
//		12. Find the common elements between two arrays
		findCommonElement(arr1, arr2);
		
//		13. Reverse each word of a string using Java 8 streams
		reverseEachWord("Hello my name is Abhishek");
	}


	private static void reverseEachWord(String string) {
	
		String collect = Arrays.asList(string.split(" ")).stream().map(e -> {
			StringBuilder builder = new StringBuilder(e);
			return builder.reverse().toString();
		}).collect(Collectors.joining(" ")).toString();
	
		System.out.println(collect);
	}


	private static void findCommonElement(Integer[] arr1, Integer[] arr2) {

		List<Integer> collect = Arrays.stream(arr1).filter(Arrays.asList(arr2)::contains).collect(Collectors.toList());
		System.out.println(collect);
	}


	private static void sortByStringLength(List<String> stringList) {
		Comparator<String> sort = (a, b) -> {
			if(a.length() > b.length()) {
				return 1;
			}else if(a.length() < b.length()) {
				return -1;
			}else {
				return 0;
			}
		};
		List<String> collect = stringList.stream().sorted(sort).collect(Collectors.toList());
		System.out.println(collect);
	}


	private static void findSecondLargestNum(Integer[] arr1) {
	
		int asInt = Arrays.stream(arr1).distinct().sorted().skip(arr1.length - 2).findFirst().get();
		System.out.println(asInt);
	}


	private static void findSumAndAvarage(List<Integer> list) {
		ToIntFunction<Integer> fun = (a) -> a;
		long sum = list.stream().collect(Collectors.summarizingInt(fun)).getSum();
		System.out.println(sum);
		
		double doubleValue = list.stream().collect(Collectors.averagingDouble((a) -> a)).doubleValue();
		System.out.println(doubleValue);
	}


	private static void checkAnagrams(String str1, String str2) {
		
		str1 = str1.chars().mapToObj(e -> ((char)e)+"").sorted().collect(Collectors.joining());
		str2 = str2.chars().mapToObj(e -> ((char)e)+"").sorted().collect(Collectors.joining());
		System.out.println(str1.equals(str2));
		
//		Another way is check frequency of each character in this string is equal 
		
	}


	private static void findThreeMinMaxNum(List<Integer> list) {
		Comparator<Integer> sort = (a, b) -> {
			if(a > b) {
				return 1;
			}else if(a < b) {
				return -1;
			}else {
				return 0;
			}
		};
		
		List<Integer> min = list.stream().sorted(sort).limit(3).collect(Collectors.toList());
		List<Integer> max = list.stream().sorted(sort.reversed()).limit(3).collect(Collectors.toList());
		System.out.println("min :: " + min);
		System.out.println("max :: " + max);
	}


	private static void mergeArray(Integer[] arr1, Integer[] arr2) {
		
		Object[] result = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
		
		for(Object i : result) {
			System.out.print((Integer)i);
			System.out.print(" ");
		}
		System.out.println();
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
