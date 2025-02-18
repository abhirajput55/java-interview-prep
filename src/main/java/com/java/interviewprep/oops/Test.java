package com.java.interviewprep.oops;

public class Test {

	public static void main(String[] args) {
		
		SubChild p1 = new Parent();
		p1.test();
		
//		Child p2 = new Parent();
//		p2.test();
		
	}
	
}

class Parent extends SubChild implements Child {
	
	public void test() {
		
		System.out.println("Parent Method : " + super.data);
	}
	
	public Parent() {
		System.out.println("Parent Constructor");	
	}
}

interface Child {

	public void test();
	
}

abstract class SubChild {
	
	final int x;
	
	public int data;

	public abstract void test();
	
	{
		System.out.println("instance block");
		x = 10;
	}
	
	static {
		System.out.println("static block");
	}
	
	
	public SubChild() {
		System.out.println("SubChild Constructor : " + x);
	}
	
}

class SubClass extends Parent {
	
	public void display() {
		
	}
	
}




