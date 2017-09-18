package bST;

public class InsertAndDelete {
	 //insertion and deletion in a BST:
	 
    static class BinarySearchTree {
        class Node {
            int data;
            Node left;
            Node right;
            Node(int data,Node left,Node right){
                this.data = data;
                this.left = left;
                this.right = right;
            }
       
        } 
     
         Node head;
         
         
        public boolean insert(int number){
             Node temp = head;
             return insertInto(temp, number);               
         }    
         
         
         public boolean insertInto(Node node, int number) {
             if(node == null) {
                 node = new Node(number, null, null);
                 head = node;
                 return true;
             }
             if(node.data <= number){//right
                 if(node.right != null){
                     node = node.right;
                     return insertInto(node, number);
                 }
                 else{
                     node.right = new Node(number, null, null);
                     return true;
                 }             
             }
             else {
                 if(node.left != null) {
                     node = node.left;
                     return insertInto(node,number);
                 }
                 else{
                     node.left = new Node(number, null,null);
                     return true;
                 }
             }
            // return false;
         }
         
         
         public void delete(int number){
             Node temp = head;
             deleteInTree(temp, number);
         }
         
         public Node deleteInTree(Node node, int number){
             
             if(node.data == number){
                 if((node.left != null) && (node.right != null)){
                     int val = getLeft(node.right);
                     node.data = val;
                     node.right = deleteInTree(node.right,val);
                     return node;
                     
                 }
                 else if(node.left != null){
                     return node.left;
                 }
                 else if(node.right != null){
                     return node.right;
                 }
                 else if(node.left == null && node.right == null){
                     return null;
                 }
             
             
             }
             else if(node.data < number){
                 if(node.right != null){
                     node.right = deleteInTree(node.right, number);
                 }
                 else{
                     return null;
                 }
                
             }
              else if(node.data > number){
                 if(node.left != null){
                     node.left = deleteInTree(node.left, number);
                 }
                 else{
                     return null;
                 }
               
             }
             return null;       
         
         
         
         }
         
         
        public  int getLeft(Node node){
             Node temp = node;
             while(temp != null){
                 if(temp.left != null)
                     temp = temp.left;
                 else
                     return temp.data;
                    
             }
             return temp.data;
             
         }
        
        public void print(){
        	Node temp = head;
        	printNodes(temp);
        }
        
        public void printNodes(Node node){
        	if(node == null){
        		return;
        	}
        	if(node.left != null){
        		printNodes(node.left);
        	}
        	System.out.print(node.data+" ");
        	if(node.right != null){
        		printNodes(node.right);
        	}
        }
         
         
         public static void main(String[] args) {
			BinarySearchTree bst = new BinarySearchTree();
			System.out.println(bst.insert(2));
			bst.insert(1);
			bst.insert(0);
			bst.insert(3);
			bst.print();
			System.out.println();
			bst.delete(1);
			bst.print();
		}
         
    }     
     
     
}
