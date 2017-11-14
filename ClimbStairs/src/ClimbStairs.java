import java.util.HashMap;

public class ClimbStairs {

	//Top Down Approach
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
	
	public static int climbStairsMemozation(int n) {
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		return countWays1(n, cache);
		
	}
	
	public static int countWays1(int n, HashMap<Integer, Integer> cache) {
		if(n==0)
			return 1;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		
		cache.put(n, countWays(n-1) + countWays(n-2) + countWays(n-3));
		return cache.get(n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(6));
		System.out.println(climbStairsMemozation(6));
	}

}
