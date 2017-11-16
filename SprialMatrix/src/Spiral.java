import java.util.*;
public class Spiral {

	public static void printSpiralMatrix(int[][] matrix, int row, int col) {
		int r=0, c=0;
		List<Integer> list = new ArrayList<Integer>();
		
		while(r<row && c<col) {
			for(int i=c;i<col;i++) {
				System.out.println(matrix[r][i]+" ");
				list.add(matrix[r][i]);
			}
			r++;
			for(int i=r;i<row;i++) {
				System.out.println(matrix[i][col-1]+" ");
				list.add(matrix[i][col-1]);
			}
			
			col--;
			
			if(r<row) {
				for(int i=col-1;i>=c;i--) {
					System.out.println(matrix[row-1][i]+" ");
					list.add(matrix[row-1][i]);
				}
				row--;
			}
			
			if(c < col) {
				for(int i=row-1;i>=r;i--) {
					System.out.println(matrix[i][c]+ " ");
					list.add(matrix[i][c]);
				}
				c++;
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiral s = new Spiral();
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		
		printSpiralMatrix(matrix, matrix.length, matrix[0].length);
	}

}
