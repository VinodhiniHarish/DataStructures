
public class UniquePaths {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int count = 0;
        return uniquePathsHelper(obstacleGrid, 0, 0, obstacleGrid.length-1,obstacleGrid[0].length-1,count);
    }
    public static int uniquePathsHelper(int[][] obstacleGrid,int currX, int currY,int row,int col,int count){
        if(obstacleGrid[0][0] == 1)
            return 0;
        if(currX > row || currY > col || obstacleGrid[currX][currY] == 1)
            return 0;
        if(currX == row && currY == col)
        	return 1;
        count+= uniquePathsHelper(obstacleGrid, currX, currY+1, row, col,count) + uniquePathsHelper(obstacleGrid, currX+1,currY, row, col,count);
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths u = new UniquePaths();
		int[][] matrix = {
				{0,0,0},
				{0,1,0},
				{0,0,0}
		};
		System.out.println(u.uniquePathsWithObstacles(matrix));
	}

}
