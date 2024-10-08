package com.java.interviewprep.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExamples {
	
	public static void main(String[] args) {
		
		List<Integer> numList = new ArrayList<>(Arrays.asList(1, 2, 7, 8, 5, 10, 4, 23, 44, 3, 13, 48));
		List<String> stringList = new ArrayList<>(Arrays.asList("java", "python", "cpp", "javascript", "ruby", "css", "html", "sql"));
		List<Employee> empList = new ArrayList<>(Arrays.asList(new Employee("Abhi", 647), new Employee("Dinesh", 809), new Employee("Saurabh", 809), new Employee("Abhishek", 647)));
		
//		filterProgram(numList);
//		mapProgram(stringList);
//		sumProgram(numList);
//		distinctProgram();
//		groupProgram(empList);
//		sortingProgram(stringList);
//		chainingProgram();
//		flatMapProgram();
//		collectingToMap(stringList);
		parallelStreamExample();
	}
	
	/* 1. Filtering and Collecting: */
//	Given a list of integers, write a stream operation to filter out all even numbers 
//	and collect the remaining odd numbers into a new list.
	
	public static void filterProgram(List<Integer> numList) {
		
		Predicate<Integer> p = i -> i%2==0;
		
		System.out.println(numList.stream().filter(p.negate()).collect(Collectors.toList()));
	}
	
	/* 2. Mapping */
//	Create a list of strings representing names. 
//	Use streams to convert all names to uppercase and collect the results into a new list.

	public static void mapProgram(List<String> list) {
		System.out.println(list.stream().map(e -> e.toUpperCase()).collect(Collectors.toList()));
	}
	
	/* 3. Finding Unique Elements: distinct */
//	Write a stream operation to find the unique elements from a list of integers.
	
	public static void distinctProgram() {
		List<Character> charList = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'a', 'i', 'o', 'e', 'o', 'u')); 
		System.out.println(charList.stream().distinct().collect(Collectors.toList()));
	}

	
	/* 4. Reducing: Sum */
//	Given a list of integers, use a stream to calculate the sum of all numbers in the list.
	
	public static void sumProgram(List<Integer> numList) {
		BinaryOperator<Integer> b = (i, j) -> i + j;
		System.out.println(numList.stream().reduce(0, b));
	}
	
	/* 5. Grouping: */
//	Given a list of people (with attributes like name and age), write a stream operation to group them by age.
	
	public static void groupProgram(List<Employee> empList) {
		
		Function<Employee, Integer> f = e -> e.getEmpNo();
		
		Map<Integer, List<Employee>> collect = empList.stream().collect(Collectors.groupingBy(f));
		
		System.out.println(collect);
	}
	
	
	/* 6. Sorting: */
//	Write a stream operation to sort a list of strings by their length, 
//	and then by alphabetical order for strings of the same length.

	public static void sortingProgram(List<String> list) {
		
		Comparator<String> compareOnLength = (s1, s2) -> {
			if(s1.length() < s2.length())
				return -1;
			else if(s1.length() > s2.length())
				return 1;
			else
				return 0;
		};
		
		Comparator<String> compareAlphabetical = (s1, s2) -> {
			if(s1.length() == s2.length())
				return s1.compareTo(s2);
			else
				return 0;
			
		};
		
		
		List<String> collect = list.stream().sorted(compareOnLength).sorted(compareAlphabetical).collect(Collectors.toList());
		System.out.println(collect);
	}
	
	
	/* 7. Chaining Operations: */
//	Given a list of products (with price and name), 
//	write a stream operation to find the average price of all products whose name contains the letter 'a'.
	
	public static void chainingProgram() {

		List<Product> products = new ArrayList<>(Arrays.asList(new Product("Jeans", 1000), new Product("Kit", 3000),
				new Product("Earbuds", 2500), new Product("Mobile", 5000)));

		Double collect = products.stream().filter(p -> p.getName().contains("a"))
				.collect(Collectors.averagingDouble(p -> p.getPrice()));
		
		System.out.println(collect);
	}
	
	
	/* 8. FlatMap: */
//	Given a list of lists of integers, use flatMap to create a single list containing all integers from the sublists.
	
	public static void flatMapProgram() {
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
		List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
		List<List<Integer>> list = new ArrayList<>(Arrays.asList(list1, list2, list3));
		
		List<Integer> collect = list.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
		System.out.println(collect);
	}
	
	/* 9. Collecting to Map: */
//	Given a list of names, create a map where the key is the name and the value is the length of the name.
	
	public static void collectingToMap(List<String> list) {
		
		Map<String, Integer> collect = list.stream().collect(Collectors.toMap(e -> e, e -> e.length()));
		
		System.out.println(collect);
	}
	
	/* 10. Parallel Streams: */
//	Discuss how to improve performance using parallel streams when processing a large collection. 
//	What are some considerations to keep in mind?
	
	public static void parallelStreamExample() {
		List<Product> products = getProducts();
		long start = 0;
		long end = 0;
		
		start = System.currentTimeMillis();
		double normal = products.stream().mapToInt(p -> p.getPrice()).average().getAsDouble();
		end = System.currentTimeMillis();
		
		System.out.println("Normal Avg Price Of 1000 products :: " + normal + ". And time taken for it :: " + (end - start));
		
		start = System.currentTimeMillis();
		double parallel = products.parallelStream().mapToInt(p -> p.getPrice()).average().getAsDouble();
		end = System.currentTimeMillis();
		
		System.out.println("Parallel Avg Price Of 1000 products :: " + parallel + ". And time taken for it :: " + (end - start));
	}
	
	public static List<Product> getProducts(){
		List<Product> products = new ArrayList<Product>();
		
		for(int i=1; i<=1000; i++) {
			products.add(new Product("Product"+i, Integer.valueOf(new Random().nextInt(1000))));
		}
		
		return products;
	}
	
	
}


class Product {
	
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
}
