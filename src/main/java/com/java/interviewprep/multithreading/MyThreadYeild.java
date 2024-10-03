package com.java.interviewprep.multithreading;

public class MyThreadYeild extends Thread {
	
	public void run() {
		for(int i=0; i<5; i++) {
			Thread.yield();
			System.out.println("MyThreadYeild-" + i);
		}
	}
}
