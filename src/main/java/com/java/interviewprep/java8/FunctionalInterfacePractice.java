package com.java.interviewprep.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

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
	 * while defining functional interface it will show compile time error if we not use it.
	 */
	
//	Can a functional interface extend another interface? If yes, what are the rules?
	/* 
	 * Yes, a functional interface can extends another interface.
	 * But our parent interface should contain only one method in it.
	 * And our child interface should not contain any method in it.
	 * Our child interface can only contain the overridden method present in parent.
	 * 
	 */
	
//	Anonymous Inner Class vs Lambda Expression
	/* 
	 * Anonymous Inner Class can extend a normal class.
	 * Anonymous Inner Class can extend an abstract class.
	 * Anonymous Inner Class can implements an interface with any number of abstract method in it.
	 * 
	 * But
	 * Lambda Expression can only implements an in interface with single abstract method in it i.e. Functional Interface.
	 * 
	 */
	
	/*Functional Interfaces and Lambda Expressions*/
//	Write a lambda expression for a custom functional interface that accepts two numbers and returns their sum.
	public static void twoSum(int a, int b) {
		
		TwoSumInterface i = (num1, num2) -> num1+num2;
		System.out.println(i.sum(a, b));
	}
	
	public static void squareRoot(int num) {
		
		SquareRootInterface si = i -> i * i;
		System.out.println(si.squareRoot(num));
	}
	
	
	/*Common Functional Interfaces*/
//	What is the difference between Predicate<T>, Function<T, R>, Supplier<T>, and Consumer<T>? Provide examples of each.
	/* 
	 * Predicate takes one argument as input of any type and returns only boolean value.
	 * Function takes one argument of any type and returns any type of value.
	 * Supplier doesn't take any input argument and returns any type of value.
	 * Consumer takes one argument as input of any type and doesn't return any type of value.
	 * 
	 * Predicate contains boolean test(T t) method.
	 * Function contains R apply(T t) method.
	 * Supplier contains T get() method.
	 * Consumer contains accept(T t) method.
	 * 
	 */

//	Write a program using the Predicate<T> functional interface to filter a list of numbers and print only even numbers.
	public static void predicateDemo(List<Integer> list){
		
		Predicate<Integer> p = i -> i%2==0;
		List<Integer> collect = list.stream().filter(p).collect(Collectors.toList());
		System.out.println(collect);
	}
	
//	Explain the BiFunction<T, U, R> interface. How does it differ from Function<T, R>?
	/* 
	 * The BiFunction interface can take two arguments as input but 
	 * Function interface can take only one argument as input. 
	 * 
	 */
	
//	How can you use the UnaryOperator<T> functional interface? Write a program to square the elements of a list using UnaryOperator.
	/* 
	 * If our input and output type is same then we can use UnaryOperator<T>.
	 * It is the child class of Function<T, T> functional interface.
	 * UnaryOperator takes only one input argument.
	 */
	public static void unaryOperatorEx(List<Integer> list) {
		
		UnaryOperator<Integer> square = i -> i * i;
//		We can also use primitive type UnaryOperator for primitive values.
//		This is to avoid internal autoboxing and autounboxing of values.
		IntUnaryOperator intSquare = i -> i * i;
		int[] arr = {1, 2, 3, 4, 5, 6};
		
		list.forEach(e -> System.out.println(square.apply(e)));
		for(int i=0; i<arr.length; i++) {
			System.out.println(intSquare.applyAsInt(arr[i]));
		}
	}
	
//	How do method references work in the context of functional interfaces? Provide examples of a static method reference and an instance method reference.
	
	/*Advanced Topics*/
//	Can a functional interface have default or static methods? If yes, how does it still remain a functional interface?
	
	/* 
	 * We can take default methods only in interfaces but not in any class. 
	 * We can not define object class methods as default methods in an interface 
	 * because our object class methods are already available to every class.
	 * If two interfaces have same default method the we should provide implementation 
	 * for that method in our class in which we have implements that interfaces.
	 * 
	 * We can call static methods without creating an object. Hence why we should use class for only static methods.
	 * From Java 1.8 version we can take static methods in an interface because we does not have to create an object to call static methods.
	 * We can call interface static methods by using interface name only in any implementation class or non-implementation class.
	 * From Java 1.8 version we can take static methods in an interface hence we can take main method in an interface from 1.8 version.
	 * 
	 * 
	 */
//	What is the role of Comparator<T> as a functional interface in Java 8? Write a program to sort a list of Employees by empNo using Comparator.
	public static void comparatorSortMethod(List<Employee> empList) {
		Comparator<Employee> c = (a, b) -> (a.empNo < b.empNo) ? -1:(a.empNo > b.empNo) ? 1:0;
		Collections.sort(empList, c);
		System.out.println(empList);
	}
	
//	Write a program that uses BinaryOperator<T> to combine elements from two lists.
	/* 
	 * If we have two inputs of same type and output type is also same then we can use BinaryOperator<T>.
	 * It is the child class of BiFunction<T, T, T> functional interface.
	 * BinaryOperator takes two input argument.
	 */
	public static void combineTwoList(List<Integer> list1, List<Integer> list2) {
		
		BinaryOperator<List<Integer>> combineLists = (l1, l2) -> {
			l1.addAll(l2);
			return l1;
		};
		
		System.out.println(combineLists.apply(list1, list2));
	}
	
	/*Scenarios and Challenges*/
//	Create a chain of Predicate<T> conditions using and(), or(), and negate() methods. Write a program that checks if a number is greater than 5 and even, or if it is negative.
	public static void predicateAndOrNigate() {
		List<Integer> list = new ArrayList<>(Arrays.asList(-1, 2, 7, 8, 5, 10, -4, 23, 44, -3, 13, 48));
		Predicate<Integer> p = i -> i > 5;
		Predicate<Integer> isEven = i -> i%2==0;
		Predicate<Integer> isNegative = i -> i < 0;
		
		List<Integer> collect = list.stream().filter(p.and(isEven).or(isNegative)).collect(Collectors.toList());
		List<Integer> collect1 = list.stream().filter(p.and(isEven).or(isNegative).negate()).collect(Collectors.toList());
		System.out.println(collect);
		System.out.println(collect1);
	}
//	Given a list of strings, write a program using Function<T, R> to convert all strings to uppercase and print them.
	public static void convertToUppercase(String str) {
		
		Function<String, String> f = s -> s.toUpperCase();
		Function<String, String> f1 = s -> s.toLowerCase();
		System.out.println(f.apply(str));
		System.out.println(f.andThen(f1).apply(str));	// first f and then f1
		System.out.println(f1.compose(f).apply(str));	// first f and then f1
	}
	
//	How can you implement lazy loading using Supplier<T>? Write an example.
//	Write a program using BiConsumer<T, U> to iterate over a map and print its entries.
	
	public static void biConsumerDemo() {
		Map<Integer, String> map = new HashMap<>();
		
		BiConsumer<Integer, String> bc = (i, s) -> map.put(i, s);
		
		bc.accept(101, "Abhishek");
		bc.accept(102, "Saurabh");
		bc.accept(103, "Dinesh");
		bc.accept(104, "Mangesh");
		bc.accept(105, "Rahul");
	}
	
//	Can functional interfaces be used in multithreading? Write a program that uses a functional interface to start a new thread with a lambda expression.
	public static void startNewThread() {
		
		Runnable r = () -> {
			for(int i=0; i<5; i++) {
				System.out.println("Child Thread");
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("Main Thread");
		}
		
	}

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 7, 8, 5, 9, 23, 45, 12, 43));
		List<Employee> empList = new ArrayList<>(Arrays.asList(new Employee("Abhi", 647), new Employee("Dinesh", 809), new Employee("Saurabh", 356), new Employee("Abhishek", 290)));
		
//		twoSum(3, 7);
//		squareRoot(4);
//		predicateDemo(list);
//		comparatorSortMethod(empList);
//		predicateAndOrNigate();
//		startNewThread();
//		convertToUppercase("asdfghj");
//		unaryOperatorEx(list);
		combineTwoList(list, list);
	}
}

class Employee {
	
	String name;
	int empNo;
	
	public Employee(String name, int empNo) {
		this.name = name;
		this.empNo = empNo;
	}
	
	public String toString() {
		return name + "::" + empNo; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getEmpNo() {
		return this.empNo;
	}
}

@FunctionalInterface
interface TwoSumInterface{
	int sum(int a, int b);
}

@FunctionalInterface
interface SquareRootInterface{
	int squareRoot(int num);
}
