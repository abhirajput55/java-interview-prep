package com.java.interviewprep.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class QueueQuestions {
	
	public static void main(String[] args) {
		
//		Implement a Queue: 
//		Use a LinkedList to implement a simple queue with enqueue and dequeue operations.
		implementQueue();
		
//		PriorityQueue: 
//		Write a method that takes a list of tasks with priorities and schedules them using a PriorityQueue
		List<Task> tasks = new ArrayList<Task>(Arrays.asList(new Task("Gaming", 2), new Task("Gym", 2), new Task("Office", 3), new Task("Learning", 4)));
		scheduleTaskOnPriorities(tasks);
		
	}
	
	public static void implementQueue() {
		
		SimpleQueue<Integer> simpleQueue = new SimpleQueue<Integer>();
		simpleQueue.enqueue(1);
		simpleQueue.enqueue(2);
		simpleQueue.enqueue(3);
		simpleQueue.enqueue(4);
		simpleQueue.enqueue(5);
		
		System.out.println(simpleQueue.peek());
		System.out.println(simpleQueue.dequeue());
		System.out.println(simpleQueue.dequeue());
		System.out.println(simpleQueue.toString());
	}
	
	
	private static void scheduleTaskOnPriorities(List<Task> tasks) {
		
		PriorityQueue<Task> priorityQueue = new PriorityQueue<Task>(tasks);
		
		while (!priorityQueue.isEmpty()) {
			
//			Retrieves and removes the head of this queue,or returns null if this queue is empty.
			Task task = priorityQueue.poll();
			System.out.println(task);
		}
		
	}

}

class SimpleQueue<T> {
	
	private LinkedList<T> list;
	
	public SimpleQueue() {
		list = new LinkedList<>();
	}
	
//	Enqueue Operation
	public void enqueue(T item) {
		list.addLast(item);
	}
	
//	Dequeue Operation
	public T dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		return list.removeFirst();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
// 	Peek at the front item of the queue without removing it
	public T peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		return list.getFirst();
	}
	
	public String toString() {
		return list.toString();
	}
}


class Task implements Comparable<Task> {
	
	private String task;
	private int priority;
	
	public Task(String task, int priority) {
		this.task = task;
		this.priority = priority;
	}
	
	public String getTask() {
		return this.task;
	}
	
	public int getPriority() {
		return this.priority;
	}

	@Override
	public int compareTo(Task other) {
		return Integer.compare(this.priority, other.priority);
	}
	
	public String toString() {
		return this.task + " :: " + this.priority;
	}
}
