package com.java.interviewprep.multithreading;

public class JoinMethod {
	
	public static void main(String[] args) throws InterruptedException {
		
		JoinMethodThread t = new JoinMethodThread();
		
		t.start();
//		t.join();
//		t.join(3000);
		t.join(3000, 100);
		
		for(int i=0; i<5; i++) {
			System.out.println("MainThread-" + i);
		}
	}

}
