package com.java.interviewprep.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadingEnhancementPart4 {
	
	public static void main(String[] args) {
		
//		submitMethodDemo();
		callableAndFuture();
	}
	
	
	public static void threadPool() {
		
		/* Thread Pool (Executor Framework) */
		
//		Creating a new thread for every job may create performance and memory problems.
//		To overcome this we should go for thread pool.
//		Thread Pool is a pool of already created threads ready to do our job.
//		Java 1.5 version introduces Thread Pool Framework to implement thread pools.
//		Thread Pool Framework also known as Executor Framework.
		
		
//		We can create a Thread Pool as follows
		ExecutorService service = Executors.newFixedThreadPool(4);
		
//		We can submit a Runnable job by using submit() method.
		Runnable r = () -> {
			System.out.println("My Job");
		};
		service.submit(r);
		
//		We can shutdown executor service by using shutdown() method.
		service.shutdown();
		
	}
	
	public static void submitMethodDemo() {
		
		PrintJob[] printJobs = {new PrintJob("Abhishek"),
								new PrintJob("Dinesh"),
								new PrintJob("Saurabh"),
								new PrintJob("Tejas"),
								new PrintJob("Rahul"),
								new PrintJob("Sahil") };
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(PrintJob job : printJobs) {
			service.submit(job);
		}
		
		service.shutdown();
		
//		In the above example 3 threads are responsible to execute 6 jobs.
//		So that a single thread can be reused for multiple jobs.
		
//		While designing or developing Web Servers and Application Servers we can use Thread Pool concept.
	}
	
	public static void callableAndFuture() {
		
		/* Callable and Future */
		
//		In the case of Runnable job thread won't return anything after completing the job.
//		If a thread is required to return some result after execution then we should go for Callable Interface.
		
//		Callable Interface contain only one method.
//		public Object call() throws Exception
		
//		If we submit a Callable object to executor service then 
//		after completing the job thread returns an object of the type Future Class.
		
//		i.e. Future object can be used to retrieve the result from Callable job.
		
		MyCallable[] sumJobs = {new MyCallable(10),
								new MyCallable(20),
								new MyCallable(30),
								new MyCallable(40),
								new MyCallable(50),
								new MyCallable(60)};
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(MyCallable job : sumJobs) {
			Future<Integer> future = service.submit(job);
			try {
				System.out.println(future.get());				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		service.shutdown();
		
	}
	
	public static void diffBetnRunAndCall() {
		
		/* Differences between Runnable and Callable */
		
//		1) If a thread is not required to return anything after completing the job then we should go for Runnable.
//		If a thread required to return something after completing the job the we should go for Callable.
//		2) Runnable interface contains only one method run(). Callable interface contains only one method call().
//		3) Runnable job not required to return anything and hence return type of run method is void.
//		Callable job is required to return something and hence return type of call method is Object.
//		4) Within the run method if there is any chance of raising checked exception compulsory we should handle by using try catch because we can't use throws keyword for run method.
//		Within the call method if there is any chance of raising checked exception we are not required to handle by using try catch because call method already throws exception.
//		5) Runnable interface present in java.lang package. Callable interface present in java.util.concurrent package.
//		6) Runnable introduced in 1.0 version. Callable introduced in 1.5 version.
	}
	

}

class MyCallable implements Callable<Integer> {

	int num;
	
	public MyCallable(int num) {
		this.num = num;
	}
	
	@Override
	public Integer call() throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " : calculating sum of first " + num + " numbers.");
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		
		return sum;
	}
	
}

class PrintJob implements Runnable {

	String name;
	
	public PrintJob(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		
		System.out.println(name + " : job started by : " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println(name + " : job completed by : " + Thread.currentThread().getName());
	}
	
}
