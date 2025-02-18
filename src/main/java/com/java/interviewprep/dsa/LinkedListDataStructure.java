package com.java.interviewprep.dsa;

public class LinkedListDataStructure {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.insertAtEnd(1);
		list.insertAtEnd(1);
		list.insertAtEnd(1);
		
//		list.insertAtEnd(54);
//		list.insertAtEnd(72);
//		list.insertAtEnd(48);
//		list.insertAtEnd(92);
//		
//		list.insertAtStart(28);
//		
//		list.insertAtMiddle(3, 83);
		
//		list.deleteFromEnd();
		
//		list.delete(92);
		
		list.display();
		
//		list.reverseList();
		
		list.deleteDuplicates();
		
		list.display();
	}

}

class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	
	Node head;
	
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
		
	}
	
	public void insertAtStart(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAtMiddle(int index, int data) {
		Node newNode = new Node(data);
		Node current = head;
		int i = 0;
		while(current != null && current.next != null && i < index) {
			if(i == index-1) {
				Node temp = current.next;
				current.next = newNode;
				newNode.next = temp;
				break;
			}else {
				current = current.next;
				i++;
			}
		}
		
	}
	
	public void deleteFromEnd() {
		
		Node current = head;
		while(current != null && current.next != null) {
			if(current.next.next == null) {
				current.next = null;
			}else {
				current = current.next;				
			}
		}
	}
	
	public void delete(int data) {
		
		Node current = head;
		
		while(current != null && current.next != null && current.next.data != data) {
			current = current.next;
		}
		
		if(current != null && current.next != null ) {
			current.next = current.next.next;
		}
	}
	
	public void display() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		
		System.out.println();
	}
	
	public void reverseList() {
        Node current = head;
        Node prev = null;
        while(current != null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }
	
	public Node deleteDuplicates() {
        
        Node current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else {
            	current = current.next;            	
            }
        }

        return head;
    }
}
