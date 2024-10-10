package com.java.interviewprep.multithreading;

public class MultithreadingEnhancementPart1 {
	
	public static void main(String[] args) {
//		threadGroup();
//		activeThreadCountDemo();
		enumerateMethodDemo();
	}

	public static void threadGroup() {
		
		ThreadGroup currentthreadGroup = Thread.currentThread().getThreadGroup();
		String name = currentthreadGroup.getName();
		System.out.println("current thread group name :: " + name);  // main
		
		System.out.println("parent thread group name :: " + currentthreadGroup.getParent().getName());
		//	o/p : system
		
//		system is the root for all thread groups.
		
		
		/* Thread Group Constructors */
		
//		1. Creates a new thread group with the specified group name.
		ThreadGroup g1 = new ThreadGroup("First Group");
//		The parent of this new group is the thread group of currently executing thread.
		System.out.println(g1.getParent().getName());   // main
		
//		2. Creates a new thread group with the specified parent group and group name for the new group.
		ThreadGroup g2 = new ThreadGroup(g1, "Second Group");
//		The parent of this new group is the thread group we are providing in constructor argument.
		System.out.println(g2.getParent().getName());   // First Group
		
//		Parent to Child 
//		system -> main -> First Group -> Second Group
		
		
		/* Important Methods of ThreadGroup Class */
		
		String name2 = g1.getName();
//		returns the name of thread group.
		
		int maxPriority = g1.getMaxPriority(); 
//		returns max priority of thread group
		
		g1.setMaxPriority(4);
//		to set maximum priority of thread group.
//		The default max priority of thread group is 10.
		
//		Threads in the thread group that already have higher priority wont be affected 
//		but for newly added threads this max priority is applicable.
//		ex.
		Thread t1 = new Thread(g1, "Thread1");
		Thread t2 = new Thread(g1, "Thread2");
		g1.setMaxPriority(3);
		Thread t3 = new Thread(g1, "Thread3");
		System.out.println(t1.getPriority());	// 4
		System.out.println(t2.getPriority());	// 4
		System.out.println(t3.getPriority());	// 3
		
//		Returns parent group of current thread
		ThreadGroup prentGroup = g1.getParent();
		
//		It prints information about thread group to the console.
		g1.list();
		
//		Returns number of active threads present in the thread group.
		int activeCount = g1.activeCount();
		
//		It returns number of active thread groups inthe current thread group.
		int activeGroupCount = g1.activeGroupCount();
		
//		To copy all active threads of this thread group into provided thread array.
//		In this case sub thread group threads will be considered.
		Thread[] tArray = new Thread[10];
		int enumerate = g1.enumerate(tArray);
		
//		To copy all active sub threads groups into thread group array.
		ThreadGroup[] tgArray = new ThreadGroup[10];
		int enumerate2 = g1.enumerate(tgArray);
		
//		To check weather the thread group is daemon or no.
		boolean daemon = g1.isDaemon();
		
//		To set the daemon nature of thread.
		g1.setDaemon(true);
		
//		To interrupt all waiting or sleeping threads present in the thread group.
		g1.interrupt();
		
//		To destroy thread group and its sub thread groups.
		g1.destroy();
		
	}
	
	public static void activeThreadCountDemo() {
		
		ThreadGroup pg = new ThreadGroup("ParentGroup");
		ThreadGroup cg = new ThreadGroup(pg, "ChildGroup");
		ActiveThreadCountDemo t1 = new ActiveThreadCountDemo(pg, "Thread1");
		ActiveThreadCountDemo t2 = new ActiveThreadCountDemo(pg, "Thread2");
		
		t1.start();
		t2.start();
		
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
		
		try {
			Thread.sleep(10000);			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
	}
	
//	Write a program to display all active thread names belongs to system group and its child groups.
	public static void enumerateMethodDemo() {
		
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		
		Thread[] t = new Thread[system.activeCount()];
		
		int enumerate = system.enumerate(t);
		
		for(int i = 0; i < enumerate; i++) {
			System.out.println(t[i].getName());
		}
		
	}
}

class ActiveThreadCountDemo extends Thread {
	
	ActiveThreadCountDemo(ThreadGroup g, String name) {
		super(g, name);
	}
	
	public void run() {
		System.out.println("Child Thread");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

