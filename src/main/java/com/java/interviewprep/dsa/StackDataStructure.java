package com.java.interviewprep.dsa;

public class StackDataStructure {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		stack.push(43);
		stack.push(89);
		
		System.out.println(stack.pop());
		
		stack.push(75);
		
		System.out.println(stack.peek());
		
		stack.push(20);
		
		stack.show();
	}
}

class StackNode {
	
	int data;
	StackNode next;
	
	StackNode(int data){
		this.data = data;
		this.next = null;
	}
}

class Stack {
	
	StackNode top;
	
	public void push(int data) {
		StackNode newNode = new StackNode(data);
		
		newNode.next = top;
		
		top = newNode;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int data = top.data;
		top = top.next;
		return data;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void show() {
		StackNode current = top;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

}