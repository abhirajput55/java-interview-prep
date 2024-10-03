package com.java.interviewprep.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayListPractice {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("red");
		list.add("green");
		list.add("blue");
		list.add("orange");
		list.add("white");
		list.add("black");
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(6);
		list2.add(1);
		list2.add(5);
		
		basicOperationsOnArrayList();
//		searchElement(list);
//		sortArrayList(list);
//		copyArrayList();
//		shuffleArrayList(list);
//		reverseArrayList(list);
//		extractPortion(list);
//		compareTwoLists();
//		swapTwoElements(list);
//		joinTwoArrayList();
//		cloneArrayList(list);
//		findMaxMinElement(list2);
//		findNoOfElements(list2);
//		removeDuplicates(list2);
		
	}
	
	public static void basicOperationsOnArrayList() {
//		Write a Java program to create an array list, add some colors (strings) and print out the collection.
		ArrayList<String> list = new ArrayList<>();
		list.add("red");
		list.add("green");
		list.add("blue");
		list.add("orange");
		list.add("white");
		list.add("black");
		System.out.println(list);
		
//		Write a Java program to iterate through all elements in an array list.
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
//		Write a Java program to insert an element into the array list at the first position.
		list.add(0, "white");
		list.add(6, "black");
		System.out.println(list);
		
//		Write a Java program to retrieve an element (at a specified index) from a given array list.
		System.out.println(list.get(1));
		System.out.println(list.get(2));
//		System.out.println(list.get(7)); Exception : java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
		
		
//		Write a Java program to update an array element by the given element.
		System.out.print("List :: ");
		System.out.println(list);
		
		list.set(5, "yellow");

		System.out.print("Updated List :: ");
		System.out.println(list);
		
//		Write a Java program to remove the third element from an array list.
		list.remove("black");
		list.remove(6);
		System.out.println(list);
		
//		Write a Java program to Convert an ArrayList to Array
		Object[] array = list.toArray();
		System.out.println(array);
		
//		Write a Java program to Insert more than one element at a particular position of an ArrayList
		List<String> list3 = new ArrayList<>();
		list3.add("green");
		list3.add("blue");
		list3.add("orange");
		list.addAll(5, list3);
		System.out.println(list);
		
		
//		-----------------------------------------------------------------------------------------------------------------------------
		
//		Write a Java program to empty an array list.
		list.clear();
//		or
//		list.removeAll();
		System.out.println(list);
		
//		Write a Java program to test whether an array list is empty or not.
		System.out.println(list.isEmpty());
		
	}
	
//	Write a Java program to search for an element in an array list.
	public static void searchElement(List<String> list) {
		System.out.println(list.contains("green"));
		System.out.println(list.contains("pink"));
	}
	
//	Write a Java program to sort a given array list.
	public static void sortArrayList(List<String> list) {
		System.out.print("List Before Sort :: ");
		System.out.println(list);
		Collections.sort(list);		
	 // Collections is the utility class which contains utility methods required for all Collection Framework classes.
		System.out.print("List After Sort :: ");
		System.out.println(list);
	}
	
//	Write a Java program to copy one array list into another.
	public static void copyArrayList() {
		List<String> list1 = new ArrayList<>();
		list1.add("red");
		list1.add("green");
		list1.add("blue");
		
		List<String> list2 = new ArrayList<>();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		
		Collections.copy(list1, list2);		// (destination, source)
		System.out.println(list1);
	}
	
//	Write a Java program to copy one array list into another.
	public static void shuffleArrayList(List<String> list) {
		Collections.shuffle(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}
	
//	Write a Java program to reverse elements in an array list.
	public static void reverseArrayList(List<String> list) {
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
	}
	
//	Write a Java program to extract a portion of an array list.
	public static void extractPortion(List<String> list) {
		List<String> subList = list.subList(2, 5);
		System.out.println(subList);
	}
	
//	Write a Java program to compare two array lists.
	public static void compareTwoLists() {
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		
		List<String> list2 = new ArrayList<>();
		list2.add("1");
//		list2.add("3");
		list2.add("2");
		list2.add("3");
		
		if(list1.size()!=list2.size()) {
			System.out.println(false);
		}
		
		for(int i=0; i<list1.size(); i++) {
			if(list1.get(i).equals(list2.get(i))) {
				System.out.println(false);
				break;
			}
		}
		System.out.println(true);
	}
	
//	Write a Java program that swaps two elements in an array list.
	public static void swapTwoElements(List<String> list) {
		System.out.println(list);
//		With logic
//		String string3 = list.get(3);
//		String string4 = list.get(4);
//		list.set(3, string4);
//		list.set(4, string3);
		
//		With utility method
		Collections.swap(list, 3, 4);
		System.out.println(list);
	}
	
//	Write a Java program to join two array lists.
	public static void joinTwoArrayList() {
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		
		List<String> list2 = new ArrayList<>();
		list2.add("4");
		list2.add("5");
		list2.add("6");
		
		list1.addAll(list2);
		System.out.println(list1);
	}
	
//	Write a Java program to clone an array list to another array list.
	public static void cloneArrayList(ArrayList<String> list) {
//		By using clone method
		ArrayList<String> clonedList = (ArrayList<String>)list.clone();
//		By using constructor
		List<String> newList = new ArrayList<>(list);
		System.out.println(clonedList);
		System.out.println(newList);
	}
	
//	Write a Java program for trimming the capacity of an array list.
	public static void trimArrayListCapacity(ArrayList<String> list) {
//		By default ArrayList has initial capacity of 10 by using no arg constructor.
//		We can set the initial capacity by using constructor new ArrayList(int initialCapacity);
//		Also we can increase the capacity by using list.ensureCapacity(int capacity) method.
		
		list.trimToSize();
//		The above method trim the capacity to its size.
//		Therefore no memory will waste.
	}
	
//	Write a Java program to Find maximum and minimum element in ArrayList
	public static void findMaxMinElement(List<Integer> list) {
		Integer max = list.get(0);
		Integer min = list.get(0);
		for(Integer i : list) {
			if(i > max)
				max = i;
			
			if(i < min)
				min = i;
		}
		System.out.println("max :: ".concat(max.toString()).concat("  ").concat("min :: ").concat(min.toString()));
	}
	
//	Write a Java program how do you find the number of elements present in an ArrayList
	public static void findNoOfElements(List<Integer> list) {
		int count = 0;
		for(Integer i : list) {
			count++;
		}
		long count1 = list.stream().count();
		System.out.println(count);
		System.out.println(count1);
	}
	
//	Write a Java program to Remove Duplicates from ArrayList
	public static void removeDuplicates(List<Integer> list1) {
		List<Integer> list = list1;
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(2);
		int i;
		int j;
		for(i=0; i<list.size(); i++) {
			for(j=0; j<list.size(); j++) {
				if(i!=j && list.get(i).equals(list.get(j))) {
					list.remove(j);
				}
			}				
		}
		System.out.println(list);
		
//		With less time complexity and less code
		Set<Integer> set = new LinkedHashSet<>(list);
//		Set does not allowed duplicate elements.
		list = new ArrayList<>(set);
		System.out.println(list);
	}
	
	
}
