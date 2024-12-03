package com.java.interviewprep.dsa.progrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeSortedArrays {

//	Write a Java program to merge two sorted arrays into a single sorted array
	
	public static void main(String[] args) 
    {
        int[] arrayA = new int[] {1, 2, 4, 5, 8};
         
        int[] arrayB = new int[] {3, 6, 7, 9, 10};
         
        int[] mergedArray1 = mergeArrayUsing(arrayA, arrayB);
        int[] mergedArray2 = mergeArrayUsingJava8(arrayA, arrayB);
         
        System.out.println("Merged Array : "+ Arrays.toString(mergedArray1));
        System.out.println("Merged Array : "+ Arrays.toString(mergedArray2));
    }

	private static int[] mergeArrayUsing(int[] arrayA, int[] arrayB) {
		
		int[] mergedArray = new int[arrayA.length + arrayB.length];
		
		int i = 0, j = 0, k = 0;
		
		while(i < arrayA.length && j < arrayB.length) {
			
			if(arrayA[i] < arrayB[j]) {
				mergedArray[k] = arrayA[i];
				i++;
				k++;
			}else {
				mergedArray[k] = arrayB[j];
				j++;
				k++;
			}
		}
		
		while(i < arrayA.length) {
			mergedArray[k] = arrayA[i];
			i++;
			k++;
		}
		
		while(j < arrayB.length) {
			mergedArray[k] = arrayB[j];
			j++;
			k++;
		}
		
		
		return mergedArray;
	}

	private static int[] mergeArrayUsingJava8(int[] arrayA, int[] arrayB) {
		// Create a new array by concatenating the two arrays
		
		return IntStream.concat(Arrays.stream(arrayA), Arrays.stream(arrayB)).sorted().toArray();
	}
}
