package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOnlineData {
	
//median of online data:
    
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9,10};
		median(input);
	}
    
    static void median(int[] input){
        int index = 0, size = input.length;
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(10);
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(10,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2)
					return -1;
				else if(o1 == o2)
					return 0;
				else
					return 1;
			}
		}
            
        );
        while(index < size){
            minheap.offer(input[index++]);
        
        
            if(Math.abs(minheap.size() - maxheap.size()) > 1 ){
                int temp = minheap.remove();
               maxheap.offer(temp);
           }
        
            
        }
        if(minheap.size() == maxheap.size()){
        	float median = (float) ((minheap.remove() + (maxheap.remove()))/2.0);
        	System.out.println("Median is: "+median);
        }
        else{
        	System.out.println("Median is: "+minheap.remove());
        }
    
    
    }
    
}
