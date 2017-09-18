package bST;

import bST.ValidateBSTinBT.BinaryTree;
import bST.ValidateBSTinBT.BinaryTree.Node;

public class RangeLookUP {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTree.Node(5);

		tree.root.left = new BinaryTree.Node(4);
		tree.root.left.left = new BinaryTree.Node(3);
		tree.root.right = new BinaryTree.Node(6);
		tree.root.right.left = new BinaryTree.Node(5);
		tree.root.right.right = new BinaryTree.Node(8);
		//System.out.println(isBST(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		printEleminRange(6,9,tree.root);
	}
	
	//given range - print all elements which are in range:

    static void printEleminRange(int start, int end, Node node){
        if(node == null){
            return;
        }
        if((node.data >= start) && (node.data <= end)) {
              System.out.print(node.data+" "); 
              printEleminRange(start,node.data,node.left); 
              printEleminRange(node.data,end,node.right);      
        }
        else if(node.data <= start){
            printEleminRange(start,end,node.right);
        }
        else if(node.data >= end){
            printEleminRange(start,end,node.left);
        }
        return;
        
    }
}
