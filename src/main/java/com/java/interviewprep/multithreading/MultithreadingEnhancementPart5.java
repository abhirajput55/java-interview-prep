package com.java.interviewprep.multithreading;

public class MultithreadingEnhancementPart5 {
	
	public static void main(String[] args) {
//		overrideInitialValueMethod();
//		maintainOneThreadLocalObject();
		inheritableThreadLocalObject();
	}
	
	
	public static void threadLocal() {
		
		/* ThreadLocal */
		
//		ThreadLocal class provides thread local variables 
//		ThreadLocal class maintains values per thread basis.
//		Each threadLocal object maintains a separate value like userId, transactionId, etc.
//		for each thread that accesses that object.
//		Thread can access its local value, can manipulate its value and even can remove its value.
//		In every part of the code which is executed by the thread we can access its local variable.
	
//		Consider a Servlet which invokes some business methods.
//		We have a requirement to generate a unique transaction id for each and every request and we have to pass this transaction id to the business methods.
//		For this requirement we can use thread local to maintain a separate transaction id for every request i.e. for every Thread.
		
//		Note:
//		1) ThreadLocal class introduced in 1.2 version and enhanced in 1.5 version.
//		2) ThreadLocal can associated with thread scope.
//		3) Total code which is executed by the thread has access to the corresponding thread local variables.
//		4) A thread can access its own local variables and can't access other threads local variables.
//		5) Once thread entered into dead state all its local variables are by default eligible for garbage collection.
			
		/* Constructor */
	
//		Creates a thread local variable.
		ThreadLocal<Integer> tl = new ThreadLocal<>();
			
		/* Methods of ThreadLocal */
		
		Integer integer = tl.get();
//		Returns the value of thread local variable associated with current thread.
		
//		tl.initialValue();
//		Returns initial value of thread local variable associated with current thread.
		
//		The default implementation of this method returns null.
//		To customize our own initial value we have to override this method.
		
		tl.set(2);
//		To set a new value.
		
		tl.remove();
//		To remove the value of thread local variable associated with current thread.
		
//		Its is newly added method in 1.5 version.
//		After removal if we are trying to access it will be reinitialized once again by invoking its initial value method.
		
	}
	
	public static void overrideInitialValueMethod() {
		
		ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
			public Integer initialValue() {
				return 5;
			}
		};
		
		System.out.println(tl.get());
		tl.set(2);
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());
		
		
//		In the above program for every Customer Thread a separate custId will be maintained by ThreadLocal object.
	}
	
	public static void maintainOneThreadLocalObject() {
		
		CustomerThread c1 = new CustomerThread("Thread1");
		CustomerThread c2 = new CustomerThread("Thread2");
		CustomerThread c3 = new CustomerThread("Thread3");
		CustomerThread c4 = new CustomerThread("Thread4");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		
	}
	
	public static void inheritableThreadLocalObject() {
		
		/* ThreadLocal vs Inheritance */
		
//		Parent Threads threadLocal variable by default not available to the child thread.
//		If we want to make parent threads threadLocal variable value available to the child thread 
//		then we should go for InheritableThreadLocal class.
		
//		By default child thread value is same as parent thread value. Nut we can customized value 
//		for child thread by overriding childValue() method.
		
		/* Constructor */
		
		InheritableThreadLocal<Integer> tl = new InheritableThreadLocal<Integer>();
		
		/* Methods */
		
//		InheritableThreadLocal is the child class of ThreadLocal and hence all methods present in ThreadLocal
//		by default available to InheritableThreadLocal.
		
//		In addition to this methods it contains only on method.
		
//		public Object childValue(Object parentValue);
		
		ParentThread pt = new ParentThread();
		pt.start();
		
//		In the above program if we replace InheritableThreadLocal with ThreadLocal and
//		if we are not overriding child value method then the output is 
//		Parent thread value : pp
//		Child thread value : null
		
	}

}

class ParentThread extends Thread {
	
	public static InheritableThreadLocal<String> tl = new InheritableThreadLocal<String>() {
		public String childValue(String string) {
			return "cc";
		}
	};
	
	public void run() {
		tl.set("pp");
		System.out.println("Parent thread value : " + tl.get());
		
		ChildThread ct = new ChildThread();
		ct.start();
	}
}

class ChildThread extends Thread {
	
	public void run() {
		System.out.println("Child thread value : " + ParentThread.tl.get());
	}
}

class CustomerThread extends Thread {
	
	static Integer custId = 0;
	
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return ++custId;
		}
	};
	
	public CustomerThread(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : executing with customer id : " + tl.get());
	}
}
