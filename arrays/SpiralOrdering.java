package arrays;

public class SpiralOrdering {
	
	public static void main(String[] args) {
		int[][] input = {{1,2,3,4},{5,6,7,8}, {9,10,11,12} , {13,14,15,16}  };
		spriralorder(input);
	}
	
	
	//spiral ordering
	//for each start we traverse and display
	//traverse stops when flag turns false;
	    static void  spriralorder(int[][] matrix){
	        boolean isEnd = true;
	        for(int start = 0; (start < matrix.length) && isEnd; start++){
	             isEnd = spiralDisplay(matrix, start);
	        }
	        return;
	    }
	    
	    static boolean spiralDisplay(int[][] matrix, int start) {
	        int end = matrix.length-1-start;
	        if(start > end){
	            return false;
	        }
	        //right
	        for(int col = start; col < end; col++){
	            System.out.print(matrix[start][col]+" ");
	        }
	        //down      
	        for(int row = start; row < end; row++){
	            System.out.print(matrix[row][end]+" ");
	        }
	        //left
	        for(int col = end; col > start; col--){
	            System.out.print(matrix[end][col]+" ");
	        }
	        //top
	         for(int row = end; row > start; row--){
	            System.out.print(matrix[row][start]+" ");
	        }
	        return true;
	    }
}
