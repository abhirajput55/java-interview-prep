package com.java.interviewprep.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiPractice {

	public static void main(String[] args) {

//		Basic Stream Operations

//		Convert a List of Strings to Uppercase
		List<String> words = Arrays.asList("apple", "banana", "cherry");

		System.out.println(words.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()));

//		Find the Maximum and Minimum Number
		List<Integer> numbers = Arrays.asList(10, 3, 25, 7, 14);

		System.out.println(numbers.stream().min((a, b) -> a - b).get());
		System.out.println(numbers.stream().max((a, b) -> a - b).get());

//		Filter Out Even Numbers
		List<Integer> numbers1 = Arrays.asList(12, 7, 19, 4, 6, 9);
		System.out.println(numbers1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));

//		Sort a List in Descending Order
		List<Integer> numbers2 = Arrays.asList(5, 12, 8, 3, 17);
		System.out.println(numbers2.stream().sorted((a, b) -> a - b).collect(Collectors.toList()));

//		Count the Number of Elements
		Stream<String> stream = Stream.of("one", "two", "three", "four");
		System.out.println(stream.count());

//		Intermediate Stream Operations
//		Remove Duplicates
		List<String> names = Arrays.asList("John", "Alice", "Bob", "Alice", "John", "Mike");
		System.out.println(names.stream().distinct().collect(Collectors.toList()));

//		Find First Non-Repeating Character in a String
		String s = "swiss";
		System.out
				.println(s.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(i -> i, Collectors.counting()))
						.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey());

//		Find Sum and Average of Numbers
		List<Integer> numbers3 = Arrays.asList(5, 10, 15, 20, 25);
		System.out.println(numbers3.stream().collect(Collectors.summarizingInt(i -> i)).getSum());
		System.out.println(numbers3.stream().reduce(0, (a, b) -> a + b));

		System.out.println(numbers3.stream().collect(Collectors.averagingInt(i -> i)));

//		Convert a List of Strings to a Comma-Separated String
		List<String> words1 = Arrays.asList("Java", "Python", "C++", "Go");
		System.out.println(words1.stream().collect(Collectors.joining(", ")));

//		Group Words by Their First Character
		List<String> words2 = Arrays.asList("apple", "banana", "cherry", "avocado", "blueberry");
		System.out.println(words2.stream().collect(Collectors.groupingBy(str -> str.charAt(0), Collectors.toList())));

//		Advanced Stream Operations

//		Find the Second-Highest Number  
		List<Integer> numbers4 = Arrays.asList(10, 30, 20, 50, 40, 30);
		System.out.println(numbers4.stream().sorted((a, b) -> b - a).skip(1).findFirst().get());

//		Sort a List of Objects by Multiple Fields    
		List<Person> people = Arrays.asList(new Person("John", 30, 50000), new Person("Alice", 25, 60000),
				new Person("Bob", 30, 55000), new Person("Eve", 40, 70000));
		System.out.println(people.stream().sorted((p1, p2) -> p1.name.compareTo(p2.name)).collect(Collectors.toList()));
		System.out.println(people.stream().sorted((p1, p2) -> p1.age - p2.age).collect(Collectors.toList()));

		Comparator<Double> comp = (a, b) -> {
			if (a < b) {
				return -1;
			} else if (a > b) {
				return 1;
			} else {
				return 0;
			}
		};
		System.out.println(
				people.stream().sorted((p1, p2) -> comp.compare(p1.salary, p2.salary)).collect(Collectors.toList()));

//		Flatten a List of Lists into a Single List  
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8, 9));

		System.out.println(nestedList.stream().flatMap(e -> e.stream()).collect(Collectors.toList()));

//		Find the Longest String in a List  
		List<String> words3 = Arrays.asList("apple", "strawberry", "banana", "blueberry");
		System.out.println(words3.stream().sorted((a, b) -> b.length() - a.length()).findFirst().get());

//		Complex Real-world Scenarios

//		Filter Employees Earning More Than 50,000 and Sort by Salary  
		List<Employees> employees = Arrays.asList(new Employees("John", "IT", 60000),
				new Employees("Alice", "HR", 50000), new Employees("Bob", "IT", 75000),
				new Employees("Eve", "HR", 65000), new Employees("Mike", "Finance", 80000));
		System.out.println(employees.stream().filter(e -> e.salary > 50000)
				.sorted((a, b) -> comp.compare(a.salary, b.salary)).collect(Collectors.toList()));

//		Group Employees by Department and Find the Highest-Paid in Each  
		System.out.println(employees.stream().collect(Collectors.groupingBy(e -> e.department,
				Collectors.maxBy((a, b) -> comp.compare(a.salary, b.salary)))));

//		Find the Youngest Employee in a Company  
		List<Employees> employees2 = Arrays.asList(new Employees("John", 30), new Employees("Alice", 25),
				new Employees("Bob", 28), new Employees("Eve", 22));

		System.out.println(employees2.stream().sorted((a, b) -> a.age - b.age).findFirst().get());

//		Find the Average Salary of Employees in Each Department  
		System.out.println(employees.stream()
				.collect(Collectors.groupingBy(e -> e.department, Collectors.averagingDouble(e -> e.salary))));

//		Partition Employees into Two Groups (Salary > 50,000 and <= 50,000)  
//		(Use same Employee List as Question 16)  

		System.out.println(employees.stream().collect(Collectors.partitioningBy(e -> e.salary > 50000)));

	}

}

class Employees {
	String name;
	String department;
	double salary;
	int age;
	// Constructor, Getters, Setters

	public Employees(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Employees(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [name=" + name + ", department=" + department + ", salary=" + salary + ", age=" + age + "]";
	}
}

class Person {
	String name;
	int age;
	double salary;

	public Person(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}
