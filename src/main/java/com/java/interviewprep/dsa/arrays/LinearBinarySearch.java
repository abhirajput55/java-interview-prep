package com.java.interviewprep.dsa.arrays;

public class LinearBinarySearch {

	public static void main(String[] args) {
		
//		int[] numbers = {5, 2, 8, 1, 3};
//        int target = 8;
//        linearSearch(numbers, target);
//        
//        int[] arr = {1, 2, 3, 5, 8};  // Sorted array
//        int num = 5;
//        binarySearch(arr, num);
        
//      Write a program to find the first and last occurrence of a target in a sorted array.
        int[] input = {2, 4, 10, 10, 10, 18, 20};
        int x = 10;
//        firstAndLastOccurrence(input, x);
        
        
//      You are given a positive integer ‘n’.
//      Your task is to find and return its square root. 
//      If ‘n’ is not a perfect square, then return the floor value of sqrt(n).
        int n = 2147395599;
//      Output: 2
        
        int output = mySqrt(n);
        System.out.println(output);
        
	}

	private static int mySqrt(int x) {
		if(x == 0) {
            return x;
        }
        int left = 1;
        int right = x;
        int result = 1;

        while(left <= right){
            long mid = left + (right - left)/2;
            long square = mid * mid;
            if(square <= x){
                result = (int)mid;
                left = (int)mid + 1;
            }else if(square < x){
                left = (int)mid + 1;
            }else {
                right = (int)mid - 1;
            }
        }
        return result;
	}

	private static void firstAndLastOccurrence(int[] arr, int target) {
		int first = 0, last = 0;
		int left = 0;
		int right = arr.length - 1;

		while(left <= right){
			int mid = left + (right-left) / 2;
			
			if(arr[mid] < target) {
				left = mid + 1;
			}else if(arr[mid] > target) {
				right = mid - 1;
			}else {
//				first = mid;
//				right = mid - 1;
				last = mid;
				left = mid + 1;
			}	
		}
		
		System.out.println("firstAndLastOccurrence :: " + first + " " + last);
//		for(int i=mid+1; i<right; i++) {
//		if(arr[i] == target) {
//			continue;
//		} else {
//			last = i-1;
//			break;
//		}
//	}
//	
//	for(int j=mid-1; j>left; j--) {
//		if(arr[j] == target) {
//			continue;
//		} else {
//			first = j+1;
//			break;
//		}
//	}
	}

	private static void binarySearch(int[] arr, int num) {
		
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right) {
//			first divide an array and get middle index
			int mid = left + (right - left) / 2;
			
//			then compare our target with middle index element
			if(arr[mid] == num) {
				System.out.println("found at index :: " + mid);
				break;
			}
			
//			if our target element is greater or less than middle element 
//			then remove the respective part of that array by adjusting left and right
			if(arr[mid] < num) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}
		
	}

	private static void linearSearch(int[] numbers, int target) {
		
		for(int i=0; i<numbers.length-1; i++) {
			if(numbers[i] == target) {
				System.out.println("found at index :: " + i);
				break;
			}
		}
		
	}
}
