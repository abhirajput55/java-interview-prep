package com.java.interviewprep.multithreading;

public class YeildMethod {
	
	public static void main(String[] args) throws InterruptedException {
		
		MyThreadYeild t = new MyThreadYeild();
		t.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("MainThread-" + i);
		}
		
	}

}