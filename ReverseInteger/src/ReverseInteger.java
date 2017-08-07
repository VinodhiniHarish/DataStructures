
public class ReverseInteger {
	
	public int reverseInt(int number) {
		int ans = 0;
		while(number!=0) {
			ans = ans *10 + (number%10);
			number = number/10;
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger r = new ReverseInteger();
		int x = 1234567;
		System.out.println("Integer to be reversed " + x);
		System.out.println("Integer after reversing "+ r.reverseInt(x));
		
	}

}
