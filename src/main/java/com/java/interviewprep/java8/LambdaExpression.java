package com.java.interviewprep.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpression {
	
	public static void main(String[] args) {
		
//		Write a lambda expression that checks if a string is empty.
		Predicate<String> f = (s) -> s.isEmpty();
		System.out.println(f.test(""));
		
		
//		Implement a lambda expression to sort a list of integers in ascending order.
		List<Integer> intList = new ArrayList<>(Arrays.asList(4, 2, 9, 6, 3, 8, 5, 11, 7));
		intList.sort((a, b) -> a.compareTo(b));
		System.out.println(intList);
		
//		Create a lambda to concatenate two strings.
		CustomFunInterface c = (a, b) -> a.concat(b);
		String concatedString = c.concateTwoStrings("Hello", "World");
		System.out.println(concatedString);
	}

}

//	Create a custom functional interface and implement it using a lambda expression.
@FunctionalInterface
interface CustomFunInterface{
	
	String concateTwoStrings(String a, String b);
}