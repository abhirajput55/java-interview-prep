package com.java.interviewprep.multithreading;

public class DefineAThread {
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + " :: " + Thread.currentThread().getPriority());
		
//		MyThread t = new MyThread();
//		t.start();
		
		MyThread1 t1 = new MyThread1();
		Thread thread = new Thread(t1);
		thread.start();
		
		thread.setPriority(7);
		
		for(int i=0; i<5; i++) {
			System.out.println("MainThread-" + i);			
		}
		
	}

}

// By extending Thread Class
class MyThread extends Thread {
	
	public void run(){
		for(int i=0; i<5; i++) {
			System.out.println("MyThread-" + i);			
		}
	}
}

class MyThread1 implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("MyThread1-" + i);			
		}
	}
}
