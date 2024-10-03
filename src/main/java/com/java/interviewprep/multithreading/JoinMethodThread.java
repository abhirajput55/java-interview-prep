package com.java.interviewprep.multithreading;

public class JoinMethodThread extends Thread {
	
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("JoinMethodThread-" + i);
			try {				
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
