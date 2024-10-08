package com.java.interviewprep.java8;

public class MethodReference {
	
	/* 
	 * Functional Interface method refers to already existing method.   
	 * Code re-usability is the biggest advantage of method reference.
	 * 
	 * We can use our existing method as either instance method or static method.
	 * 
	 * for static
	 * classname::methodname
	 * 
	 * for instance
	 * object reference::methodname
	 * 
	 * The important rule to use Method Reference is that our arguments must be same 
	 * as Functional Interface method.
	 * 
	 * Method Reference is the alternative for Lambda Expression.
	 * 
	 */
	
	public static void  method1() {
		for(int i=0; i<5; i++) {
			System.out.println("Child Thread");
		}
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		
//		Runnable r = () -> {
//			for(int i=0; i<5; i++) {
//				System.out.println("Child Thread");
//			}
//		};
		
		Runnable r = MethodReference::method1;
		Thread t = new Thread(r);
		t.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("Main Thread");
		}
		
		MethodReference methodRef = new MethodReference();
		AddInterfFace f = methodRef::sum;
		System.out.println(f.add(10, 20));
		
//		In the above case functional interface add method referring to the MethodReference class instance method sum.
		
	}
}

@FunctionalInterface
interface AddInterfFace{
	public int add(int a, int b);
}
