package binarytrees;

import binarytrees.BinaryTree.Node;

public class LCA {
	
	 // least common ancestor
	 // if found at node: countleft or right count 1 then return
	 //
	 
	     static class NodeEntry {
	         Node node;
	         int count; 
	         
	         NodeEntry(Node node, int count){
	        	 this.node = node;
	        	 this.count = count;
	         }
	     }
	     
	     
	     public static void main(String[] args) {
		    	BinaryTree tree = new BinaryTree();
				tree.root = new BinaryTree.Node(1);

				tree.root.left = new BinaryTree.Node(2);
				tree.root.left.left = new BinaryTree.Node(4);
				tree.root.right = new BinaryTree.Node(3);
				tree.root.right.left = new BinaryTree.Node(5);
				tree.root.right.right = new BinaryTree.Node(6);
				System.out.println(findLCA(tree.root,tree.root.right.right,tree.root.right.right).node.data);

			}
	     
	     static NodeEntry findLCA(Node node, Node first, Node second){
	         if(node == null){
	             return new NodeEntry(null, 0);         
	         }
	         int count = 0;
	         NodeEntry left = null, right = null;
	         left  = findLCA(node.left, first, second);
	         if(left != null && left .count == 1){
	                count++;
	         }
	         else if(left != null && left .count == 2) {
	             return left ;    
	         
	         }
	         if(node.data == first.data){
	             count++;
	         }
	         else if(node.data == second.data){
	             count++;
	         }
	         if(count != 2) {
	             right  = findLCA(node.right, first, second);
	             if(right != null && right.count == 1){
	                 count++;
	             }
	             else if(left != null && right .count == 2) {
	                 return right;    
	         
	             }
	         }
	         
	         if(count == 2) {
	                 return new NodeEntry(node,2);    
	         }
	         else if(left != null && left.count == 1){
	             return left;
	         }
	         else if(right != null && right.count == 1){
	             return right;
	         }
	         else if(count == 1){
	             return new NodeEntry(node, 1);
	         }
	         else{
	        	 return new NodeEntry(null,0);
	         }
	         
	     }
}
