package com.java.interviewprep.innerclasses;

public class AnonymousInnerClass {
	
//	Sometimes we can declare ane3 inner class without name such type of inner classes are called Anonymous Inner Classes.

//	The main purpose of Anonymous inner classes is just for instant use(one time usage).
//	Based on declaration and behavior there are three types of Anonymous Inner Classes.
	
//	1. Anonymous Inner Class that extends a class.
//	1. Anonymous Inner Class that implements an interface.
//	1. Anonymous Inner Class that defined inside arguments.
	
	/* AnonymousInnerClass that extends a class */
	
	
	public static void main(String[] args) {
//		anonymousInnerClassExapmle();
		anonymousClassImplementsDemo();
	}
	
	
	public static void anonymousInnerClassExapmle() {
		
		PopCorn p1 = new PopCorn() {
			public void taste() {
				System.out.println("spicy");
			}
		};
		p1.taste();
		
		PopCorn p2 = new PopCorn();
		p2.taste();
		
		PopCorn p3 = new PopCorn() {
			public void taste() {
				System.out.println("sweet");
			}
		};
		p3.taste();
		
//		Class Names of objects. 
//		Because for every anonymous inner class .class file will be generated.  
		System.out.println(p1.getClass().getName());
		System.out.println(p2.getClass().getName());
		System.out.println(p3.getClass().getName());
	}
	
	
	/* AnonymousInnerClass that implements an interface */
	
//	Defining a thread by implementing Runnable interface.
	
	public static void anonymousClassImplementsDemo() {
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("Anonymous Child Thread.");
				}
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("Main Thread.");
		}
	}
	
	
	/* AnonymousInnerClass that defined inside arguments */
	
	public static void anonymousClassInsideArgument() {
		
		new Thread (new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("Anonymous Child Thread.");
				}
			}
		}).start();
		
		for(int i=0; i<5; i++) {
			System.out.println("Main Thread.");
		}
	}
	
	
	/* Normal Java Class vs Anonymous Inner Class */ 
	
//	A normal java class can extend only one class at a time.
//	Off course anonymous inner class can extend only one class at a time.
	
//	A normal java class can implement any number of interfaces simultaneously
//	But anonymous inner class can implement only one interface at a time.

//	A normal java class can extend a class and can implement any number of interfaces simultaneously.
//	But anonymous inner class can extend a class or can implement an interface but not both simultaneously.
	
//	In normal java class we can write any number of constructors simultaneoulsy.
//	But in anonymous inner classes we can't write any constructor explicitly
//	because the name of the class and name of the constructor must be same.
//	But anonymous inner classes not having any name.
	
//	Note:
//	1. If the requirement is standard and required several times then we should go for normal top level class.
//	2. If the requirement is temporary and required only once (instant use) then we should go for anonymous inner class.
	
	
	/* Where Anonymous Inner Classes are best suitable */
	
//	We can use anonymous inner classes frequently in GUI based applications to implement event handling.
	
	
	
	
	
	
}

class PopCorn {
	
	public void taste() {
		System.out.println("salty");
	}
}
