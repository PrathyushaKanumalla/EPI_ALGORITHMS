package dp;

public class EditDistance {
	
	public static void main(String[] args) {
		String input1 = "";
		String input2 = "abcde";
		System.out.println(editDistance(input1, 0, input1.length()-1, input2, 0, input2.length()-1));
	}
    
    static int editDistance(String input1, int start1, int end1, String input2, int start2, int end2){
        if((start1 == end1) && (start2 == end2) && (input1.charAt(start1) == input2.charAt(start2))){
            return 0;
        }
        else if(start2 > end2){
            return (end1-start1+1);
        }
        else if(start1 > end1){
            return (end2-start2+1);
        }
        int count = Integer.MAX_VALUE;
        if(input1.charAt(end1) == input2.charAt(end2)){
            count = editDistance(input1,start1,end1-1,input2,start2,end2-1);
        }
        else{
            count = Math.min(count, editDistance(input1,start1,end1-1,input2,start2,end2));
            count = Math.min(count, editDistance(input1,start1,end1,input2,start2,end2-1));
            count = Math.min(count, editDistance(input1,start1,end1-1,input2,start2,end2-1));
            count++;
        }
        return count;
    
    }
}
