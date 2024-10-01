package com.java.interviewprep.java8;

public class FunctionalInterfacePractice {
	
	/*Basic Concepts*/
//	What is a functional interface in Java 8? How is it different from a normal interface?
	/*
	 * Functional interface should contain only one abstract method and it can
	 * contains any number of default methods and static methods.
	 * 
	 * ex. Runnable contains run() 
	 * 	   Callable contains call() 
	 *     Comparable contains compareTo()
	 *     
	 * interface FunInterface{
	 * 		void method();
	 * }
	 * 
	 */
	
//	Explain the @FunctionalInterface annotation. Is it mandatory to use it?
	/*
	 * @FunctionalInterface annotation is just to specify explicitly that it is
	 * functional interface. It is not mandatory to use it but if we did any mistake
	 * while defining functional interface it will show compile time error.
	 */
	
//	Can a functional interface extend another interface? If yes, what are the rules?
	/* 
	 * Yes, a functional interface can extends another interface.
	 * But our parent interface should contain only one method in it.
	 * And our child interface should not contain any method in it.
	 * Our child interface can only contain the overridden method present in parent.
	 * 
	 * */
	
	/*Common Functional Interfaces*/
//	What is the difference between Predicate<T>, Function<T, R>, Supplier<T>, and Consumer<T>? Provide examples of each.
//	Explain the BiFunction<T, U, R> interface. How does it differ from Function<T, R>?
//	Write a program using the Predicate<T> functional interface to filter a list of numbers and print only even numbers.
//	Implement an example of a custom functional interface and use it with a lambda expression.
	
	/*Functional Interfaces and Lambda Expressions*/
//	Write a lambda expression for a custom functional interface that accepts two numbers and returns their sum.
	
	public static void twoSum(int a, int b) {
		
		TwoSumInterface i = (num1, num2) -> num1+num2;
		System.out.println(i.sum(a, b));
	}
	
	
//	How can you use the UnaryOperator<T> functional interface? Write a program to square the elements of a list using UnaryOperator.
//	How do method references work in the context of functional interfaces? Provide examples of a static method reference and an instance method reference.
	
	/*Advanced Topics*/
//	Can a functional interface have default or static methods? If yes, how does it still remain a functional interface?
//	What is the role of Comparator<T> as a functional interface in Java 8? Write a program to sort a list of strings by length using Comparator.
//	Write a program that uses BinaryOperator<T> to combine elements from two lists.
	
	/*Scenarios and Challenges*/
//	Create a chain of Predicate<T> conditions using and(), or(), and negate() methods. Write a program that checks if a number is greater than 5 and even, or if it is negative.
//	Given a list of strings, write a program using Function<T, R> to convert all strings to uppercase and print them.
//	How can you implement lazy loading using Supplier<T>? Write an example.
//	Write a program using BiConsumer<T, U> to iterate over a map and print its entries.
//	Can functional interfaces be used in multithreading? Write a program that uses a functional interface to start a new thread with a lambda expression.

	public static void main(String[] args) {
		
		twoSum(3, 7);
	}
}

@FunctionalInterface
interface TwoSumInterface{
	int sum(int a, int b);
}
