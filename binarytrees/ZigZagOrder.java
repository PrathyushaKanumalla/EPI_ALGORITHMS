package binarytrees;

import java.util.Stack;

import binarytrees.BinaryTree.Node;

public class ZigZagOrder {
	
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTree.Node(1);

		tree.root.left = new BinaryTree.Node(2);
		tree.root.left.left = new BinaryTree.Node(4);
		tree.root.right = new BinaryTree.Node(3);
		tree.root.right.left = new BinaryTree.Node(5);
		tree.root.right.right = new BinaryTree.Node(6);
		displayZigZag(tree.root);
	}
	
	
	//zig zag traversal
	//first and second stacks 
	    static void displayZigZag(Node head){
	        if(head == null){
	            return;
	        }
	        Stack<Node> stack1 = new Stack<Node>();
	        Stack<Node> stack2 = new Stack<Node>();
	        Stack<Node> first = stack1;
	        Stack<Node> second = stack2;
	        first.push(head);
	        while( !first.isEmpty() || !second.isEmpty()){
	          while(!first.isEmpty()){
	            Node node = first.pop();
	            System.out.print(node.data+" ");
	            if(node.left != null) {
	                second.push(node.left);
	            }
	            if(node.right != null){
	                second.push(node.right);
	            }
	          }
	          while(!second.isEmpty()){
	        	  Node node = second.pop();
		            System.out.print(node.data+" ");
		            if(node.right != null){
		                first.push(node.right);
		            } 
		            if(node.left != null) {
		            	first.push(node.left);
		            }
	          }
	        }
	        
	    
	    }
	    
}
