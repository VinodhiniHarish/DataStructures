import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {

	
	public static HashMap<Character, Character> map = new HashMap<Character, Character>();
	public static void buildMap() {
		map.put('(',')');
		map.put('{','}');
		map.put('[',']');
	}
	
	public static boolean isBalanced(String s) {
		buildMap();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			}else {
				if(!stack.isEmpty()) {
					char ch = stack.peek();
	//				System.out.println(s.charAt(i) + "!=" + map.get(ch));
					if(s.charAt(i) != map.get(ch)) {
						return false;
						
					}
					stack.pop();
				}else {
					return false;
				}
			}
			if(i==s.length()-1 && stack.isEmpty()) {
				return true;
			}
		}
		return false;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedParanthesis bp = new BalancedParanthesis();
		bp.buildMap();
//		System.out.println("Paranthesis to be Balanced is \n {[(])}");
//		bp.checkBalancedParanthesis("{[(])}");
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((bp.isBalanced(expression)) ? "YES" : "NO" );
        }
	}

}
