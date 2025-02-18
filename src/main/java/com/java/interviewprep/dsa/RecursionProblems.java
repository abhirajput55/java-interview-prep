package com.java.interviewprep.dsa;

public class RecursionProblems {
	
	public static void main(String[] args) {
		
//		Leetcode : 509. Fibonacci Number
		
//		The Fibonacci numbers, commonly denoted F(n) form a sequence, 
//		called the Fibonacci sequence, such that each number is the sum of the two preceding ones, 
//		starting from 0 and 1. That is,

//		F(0) = 0, F(1) = 1
//		F(n) = F(n - 1) + F(n - 2), for n > 1.
//		Given n, calculate F(n).

//		Input: n = 2
//		Output: 1
//		Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

		int n = 4;
//		Output: 3
//		Explanation: F(4) = F(3) + F(2) = F(2) + F(1) + F(2) + F(0) = 1 + 1 + 1 + 0 = 3
		System.out.println(fib(n));
		
	}
	
	public static int fib(int n) {

        if(n == 0)
            return 0;
        
        int num = 1;
        
        if(n > 2) {
        	num = fib(n - 1) + fib(n - 2);
        }
        
		return num;
    }

}
