package com.java.interviewprep.dsa.progrms;

public class CheckPrimeNum {

//	Write a Java program to check if a given number is prime
	
//	a number that can be divided exactly only by itself and 1, for example 7, 17 and 41
	
	public static void main(String[] args) {
        int number = 1;
        boolean isPrime = isPrime(number);
        System.out.println(number + " is Prime: " + isPrime);
    }

	private static boolean isPrime(int number) {
		
		if(number <= 1)
			return false;
		
		int num = (int)Math.sqrt(number);
		
		for(int i=2; i<=num; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
