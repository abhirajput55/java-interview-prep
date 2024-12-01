package com.java.interviewprep.collections.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapPracticeQuestions {
	
	public static void main(String[] args) {
		
//		Implement a method to count the frequency of each character in a string using HashMap.
		Map<Character, Integer> countFrequencyOfEachChar = countFrequencyOfEachChar("etrhjkcdqpwkckpwllmxwqml");
		
//		Write a program to sort a HashMap by its values.
		sortMapByItsValues(countFrequencyOfEachChar);
		
		List<Student>  list = new ArrayList<>(Arrays.asList(new Student("Abhishek", 76.20f), new Student("Dinesh", 68.74f), new Student("Saurabh", 60.85f)));
//		Given a list of students with their marks, find the student with the highest marks using TreeMap.
		findHighestMarkStudent(list);
		
//		Write a function that finds all the keys in a HashMap with a given value.
		findAllKeysByValue(3, countFrequencyOfEachChar);
	}

	private static Map<Character, Integer> countFrequencyOfEachChar(String string) {
		
		Map<Character, Integer> map = new HashMap<>();
		char[] charArray = string.toCharArray();
		
		for(char c : charArray) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}else {
				map.put(c, 1);
			}
		}
		
		System.out.println(map);
		
		return map;
	}
	
	private static void sortMapByItsValues(Map<Character, Integer> charMap) {
		
		Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				if(o1.getValue() < o2.getValue()) {
					return -1;
				}else if(o1.getValue() > o2.getValue()) {
					return 1;
				}else {
					return 0;
				}
			}
		};
		
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(charMap.entrySet());
		
		list.sort(comparator);
		
		LinkedHashMap<Character, Integer> map  = new LinkedHashMap<>();
		
		list.forEach(e -> {
			map.put(e.getKey(), e.getValue());
		});
		
		System.out.println(map);
	}
	
	private static void findHighestMarkStudent(List<Student> list) {
		
		Comparator<Student> comparator = (s1, s2) -> {
			if(s1.getMarks() < s2.getMarks()) {
				return -1;
			}else if(s1.getMarks() > s2.getMarks()) {
				return 1;
			}else {
				return 0;
			}
		};
		
		TreeMap<Student, Float> treeMap = new TreeMap<>(comparator);
		
		list.stream().forEach(e -> treeMap.put(e, e.getMarks()));
		
		System.out.println(treeMap.lastEntry().getKey());
		
	}
	
	private static void findAllKeysByValue(int i, Map<Character, Integer> charMap) {
		
		List<Character> collect = charMap.entrySet().stream()
				.filter(e -> e.getValue()==i)
				.map(e -> e.getKey()).collect(Collectors.toList());
		
		System.out.println(collect);
	}


}

class Student {
	private String name;
	private float marks;
	
	public Student(String name, float marks) {
		this.name = name;
		this.marks = marks;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getMarks() {
		return this.marks;
	}
	
	public String toString() {
		return this.name + " :: " + this.marks;
	}
}
