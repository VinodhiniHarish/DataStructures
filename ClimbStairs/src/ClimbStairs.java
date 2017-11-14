
public class ClimbStairs {

	public static int climbStairs(int n) {
		return countWays(n);
	}
	public static int countWays(int n) {
		if(n==0)
			return 1;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		
		return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(6));
	}

}
