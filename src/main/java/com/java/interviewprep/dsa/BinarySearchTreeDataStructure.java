package com.java.interviewprep.dsa;

public class BinarySearchTreeDataStructure {

	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder Traversal: ");
        tree.inOrder(tree.root); // Output: 20 30 40 50 60 70 80
        System.out.println();
        System.out.print("Preorder Traversal: ");
        tree.preOrder(tree.root); // Output: 50 30 20 40 70 60 80
        System.out.println();
        System.out.print("Postorder Traversal: ");
        tree.postOrder(tree.root); // Output: 20 40 30 60 80 70 50
        System.out.println();
        
        System.out.println(tree.search(tree.root, 58));
        System.out.println(tree.search(tree.root, 40));
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
	}
}

class BinarySearchTree {
	
	TreeNode root;
	
	public void insert(int data) {
		
		root = insertRecursive(root, data);
		
	}

	private TreeNode insertRecursive(TreeNode root, int data) {
		
		if(root == null) {
			root = new TreeNode(data);
		}else if(data < root.data) {
			root.left = insertRecursive(root.left, data);
		}else if(data > root.data) {
			root.right = insertRecursive(root.right, data);
		}
		
		return root;
	}
	
	// Inorder Traversal (Left -> Root -> Right)
	public void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	// Preorder Traversal (Root -> Left -> Right)
	public void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	// Postorder Traversal (Left -> Right -> Root)
	public void postOrder(TreeNode root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	// Search for a key
	public boolean search(TreeNode root, int data) {
		if(root == null)
			return false;
		
		if(root.data == data)
			return true;
		
		return data < root.data ? search(root.left, data) : search(root.right, data);
	}
	
	
	
	
	
}
