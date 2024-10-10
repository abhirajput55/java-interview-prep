package com.java.interviewprep.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadingEnhancementPart2 {

	
	public static void concurrentPackage() {
		
		/* java.util.concurrent package */
		
//		The problem with traditional synchronized keyword
//		1. We are not having any flexibility to try for a lock without waiting.
//		2. There is no way to specify maximum waiting time for a thread to get lock.
//		So that thread will wait until getting the lock which may creates performance problems.
//		which may cause deadlock.
//		3. If a thread releases a lock then which waiting thread will get that lock
//		we are not having any control on this.
//		4. There is no API to list out all waiting threads for a lock.
//		5. The synchronized keyword compulsory we have to use either at method level or within the method.
//		and it is not possible to use across multiple methods.
		
//		To overcome this problems SUN people introduced 
//		java.util.concurrent.locks package in 1.5 version.
//		It also provides several enhancements to the programmer to provide more control on concurrency.
	
		
		/* Lock Interface */
//		Lock object is similar to implicit acquired by a thread to execute synchronizes method or block.
//		Lock implementation provides more extensive operations than traditional implicit locks.
	
//		Important methods of Lock Interface
	
//		1. void lock();
//		we can use this method to acquired a lock.
//		If lock is already available then immediately current thread will get that lock.
//		If the lock is not already available then it will wait until getting the lock.
//		It is exactly same behavior of traditional synchronized keyword.
		
		
//		2. boolean tryLock();
//		To acquire the lock without waiting.
//		If the lock is available then the thread acquires the lock and returns true.
//		If the lock is not available then this method returns false and continue its execution without waiting.
//		In this case thread never be entered into waiting state.
		
		
		/*
		 * if(l.tryLock()) { 
		 * 		Perform Safe Operations 
		 * }else { 
		 * 		Perform Alternative Operations 
		 * }
		 */
		
		
//		3. boolean tryLock(long time, TimeUnit unit);
//		If lock is available then the tread will get the lock and continue its execution.
//		If the lock is not available then the thread will wait until specified amount of time.
//		Still the if the lock is not available then thread can continue its execution.
		
		
		/* TimeUnit */
//		TimeUnit is an enum present in java.util.concurrent package.
//		ex.
		Lock lock = new ReentrantLock();
		try {
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				
			}			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
//		4. void lockInterruptibly();
//		Acquires the lock if it is available and returns immediately.
//		If the lock is not available then it will wait. While waiting 
//		if the thread is interrupted then thread wont get the lock.
	
//		5. void unlock();
//		To releases the lock.
//		To call this method compulsory current thread should be owner of the lock.
//		Otherwise we will get runtime exception saying IllegalMonitorStateException.
	
	}	
	
	
}
