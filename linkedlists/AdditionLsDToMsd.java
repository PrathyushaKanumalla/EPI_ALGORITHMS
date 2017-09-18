package linkedlists;

import java.util.ArrayList;

import linkedlists.LinkedList.Node;

public class AdditionLsDToMsd {
	
	public static void main(String[] args) {
		int[] input1 = {1,2};
		int[] input2 = {1,2,3};
		
		LinkedList firstList = new LinkedList(input1);
		LinkedList secList = new LinkedList(input2);
		Node result = sum(firstList.head, secList.head);
		firstList.head = result;
		ArrayList<Integer> list = firstList.getAllElements();
		for (Integer i : list) {
			System.out.print(i+" ");
		}
	}
	
	
	// different linked lists given - different sizes: 
	// msd at right and lsd at begining

	    static Node sum(Node firstHead, Node secHead) {
	        int carry = 0, sum;
	        Node result = new Node(0,null);
	        Node firstPtr = firstHead, secPtr = secHead, resHead = result;
	        while( carry != 0 || firstPtr != null || secPtr != null) {
	            
	            if(firstPtr != null && secPtr != null){
	                sum = firstPtr.data+secPtr.data+carry;
	                firstPtr = firstPtr.next;
	                secPtr = secPtr.next;          
	            }
	            else if(secPtr == null && firstPtr == null){
	                //here carry not 0
	                sum = carry;
	            }
	            else if(secPtr == null){
	                sum = firstPtr.data+carry;
	                firstPtr = firstPtr.next;
	            }
	            else if(firstPtr == null){
	                sum = secPtr.data+carry;
	                secPtr = secPtr.next;
	            }
	            else{
	            	break;
	            }
	           
	        
	            carry = sum / 10;
	            sum = sum % 10;
	            Node temp = new Node(sum,null);
	            result.next = temp;
	            result = result.next;
	        }
	        
	        return (resHead.next != null)? resHead.next:null;
	    }
}
