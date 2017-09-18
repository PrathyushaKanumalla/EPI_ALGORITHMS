package arrays;

public class SearchIn2DArray {
	
	public static void main(String[] args) {
		int[][] input = { {1,2,3,10}, {4,5,6, 12}, {7,8,9,13}, {14, 15, 16, 17}};
		SearchIn2DArray array = new SearchIn2DArray();
		array.search(input, 1);
	}
	
	
	//search in a  2d array:
	// take i,j th value if its value is less-> it will be in next column
	// if its value is more -eliminate column and take prev row
	//when n,0 is reached-> element not present

	    void search(int[][] input, int number){
	        int row = 0, col = input[0].length-1;
	        while((row < input.length) && (col >= 0) ){
	            if(input[row][col] == number){
	                System.out.println("found at row : "+row+" and coulmn: "+col);
	                return;
	            }
	            else if (input[row][col] < number){
	                row++;
	            }
	            else if (input[row][col] > number){
	                col--;
	            }            
	        }
	        System.out.println("Not found");
	    }

}
