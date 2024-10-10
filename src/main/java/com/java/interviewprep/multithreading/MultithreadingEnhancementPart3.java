package com.java.interviewprep.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadingEnhancementPart3 {
	
	public static void main(String[] args) {
		
//		reentrantLockMethods();
//		traditionalWayToLock();
//		demoProgramForTryLock();
		retryingProgramForTryLock();
		
		
	}

	public static void reentrantLockClass() {
		
		/* ReentrantLock */
//		It is the implementation class of Lock Interface and it is the direct child class of object.
//		Reentrant means a Thread can acquire same lock multiple times without any issue.
//		Internally ReentrantLock increments threads personal count whenever we call lock method
//		and decrements count value whenever thread calls unlock method and lock will be released whenever count reaches 0;

		
		/* Constructors */
		
//		1. Creates an instance of ReentrantLock
		ReentrantLock l1 = new ReentrantLock();
		
//		2. Creates an instance of ReentrantLock with the given fairness policy.
		ReentrantLock l2 = new ReentrantLock(true);
		
//		If the fairness is true then longest waiting thread can get the lock if it available.
//		i.e. it follows first come first serve policy.
//		If fairness is false then which waiting thread will get the chance we can't expect.
		
//		The default value for fairness is false. If we are not setting fairness policy.
		
		
		/* Important methods of ReentrantLock */
		
//		All the methods of Lock interface is implemented in Reentrant class.
		
		int holdCount = l1.getHoldCount(); 
//		Returns the number of holds on this lock by the current thread, 
//		or zero if this lock is not held by the current thread
		
		boolean heldByCurrentThread = l1.isHeldByCurrentThread();
//		Returns true if current thread holds this lock and false otherwise
		
		int queueLength = l1.getQueueLength();
//		Returns the number of threads waiting for this lock.
		
//		Collection<Thread> queuedThreads = l1.getQueuedThreads();
//		Returns a collection of threads which are waiting to get this lock.
		
		boolean hasQueuedThreads = l1.hasQueuedThreads();
//		Returns true if there may be other threads waiting to acquire the lock
		
		boolean locked = l1.isLocked();
//		Returns true if any thread holds this lock and false otherwise
		
		boolean fair = l1.isFair();
//		Returns true if this lock has fairness policy is set with true.
		
//		Thread owner = l1.getOwner();
//		Returns the thread which acquires the lock.
		
	}
	
	public static void reentrantLockMethods() {
		ReentrantLock l = new ReentrantLock();
		l.lock();
		l.lock();
		
		System.out.println(l.isLocked());
		System.out.println(l.isHeldByCurrentThread());
		System.out.println(l.getQueueLength());
		System.out.println(l.getHoldCount());
		l.unlock();
		System.out.println(l.getHoldCount());
		System.out.println(l.isLocked());
		l.unlock();
		System.out.println(l.isLocked());
		System.out.println(l.isFair());
	}
	
	public static void traditionalWayToLock() {
		Display display = new Display();
		ReentrantDemoThread t1 = new ReentrantDemoThread(display, "Dhoni");
		ReentrantDemoThread t2 = new ReentrantDemoThread(display, "Kohli");
		
		t1.start();
		t2.start();
		
//		If we comment line 1 and 1 then the threads will be executed 
//		simultaneously and we will get irregular output.
		
//		If we not comment line 1 and 2 then the threads will be 
//		executed one by one and we will get regular output.
		
	}
	
	public static void demoProgramForTryLock() {
		
		TryLockDemoThread t1 = new TryLockDemoThread("Thread-1");
		TryLockDemoThread t2 = new TryLockDemoThread("Thread-2");
		
		t1.start();
		t2.start();
	}
	
	public static void retryingProgramForTryLock() {
		
		RetryDemoThread t1 = new RetryDemoThread("Thread-1");
		RetryDemoThread t2 = new RetryDemoThread("Thread-2");
		
		t1.start();
		t2.start();
	}
}

class TryLockDemoThread extends Thread {
	
	static ReentrantLock lock = new ReentrantLock();
	
	public TryLockDemoThread(String name) {
		super(name);
	}
	
	public void run() {
		
		/* Using tryLock method to lock */
		if(lock.tryLock()) {
			System.out.println(Thread.currentThread().getName() + " : got lock and performing safe operation.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}else {
			System.out.println(Thread.currentThread().getName() + " : does not get lock and performing alternative operation.");
		}
		
	}
}

class RetryDemoThread extends Thread {
	
	static ReentrantLock lock = new ReentrantLock();
	
	public RetryDemoThread(String name) {
		super(name);
	}
	
	public void run() {
		
		/* Using tryLock method for retrying to get lock */
		do {
			try {
				if(lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
					System.out.println(Thread.currentThread().getName() + " : got lock.");
					Thread.sleep(30000);
					lock.unlock();
					
					System.out.println(Thread.currentThread().getName() + " : releases lock.");
					break;
				}else {
					System.out.println(Thread.currentThread().getName() + " : unable to get lock and will try again");
				}							
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}while(true);
		
	}
}

class ReentrantDemoThread extends Thread {
	
	Display display;
	String name;
	
	ReentrantDemoThread (Display display, String name){
		this.display = display;
		this.name = name;
	}
	
	public void run() {
		
		display.wish(name);
		
	}
}


class Display {
	
	ReentrantLock lock = new ReentrantLock();
	
	/* Using traditional way to lock */
	public void wish(String name) {
		
		lock.lock();	// line - 1
		for(int i=0; i<5; i++) {
			System.out.print("Good Morning : ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.println(name);
		}
		lock.unlock();	// line - 2
	}
	
}
