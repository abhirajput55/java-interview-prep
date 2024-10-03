package com.java.interviewprep.multithreading;

public class SleepMethod {
	
	public static void main(String[] args) throws InterruptedException {
		
		SleepMethodThread t = new SleepMethodThread();
		
		t.start();
		Thread.sleep(2000);
		for(int i=0; i<5; i++) {
			System.out.println("SleepMethod-" + i);
		}
	}

}
