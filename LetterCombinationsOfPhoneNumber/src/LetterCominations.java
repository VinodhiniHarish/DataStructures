import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCominations {
	private Map<Integer,String> letter_map = new HashMap<Integer,String>();
	private int count =0;
	private ArrayList<String> s = new ArrayList<String>();
	
	public void addVlaues() {
		letter_map.put(2, "abc");
		letter_map.put(3, "def");
		letter_map.put(4, "ghi");
		letter_map.put(5, "jkl");
		letter_map.put(6, "mno");
		letter_map.put(7, "pqrs");
		letter_map.put(8, "tuv");
		letter_map.put(9, "wxyz");
		
	}
	
	public void printCombinations() {
		String x = s.get(0);
		String y = s.get(1);
		StringBuffer temp=new StringBuffer();
		for(int i=0;i<x.length();i++) {
			for(int j=0;j<y.length();j++) {
				temp.append(y.charAt(j));
				temp.append(x.charAt(i));
				System.out.println(temp.toString());
				temp = new StringBuffer();
			}
		}
		s = new ArrayList<String>();
	}
	
	public void findNumberOfDigits(int digit) {
		int n = digit;
		while(n>0) {
			s.add(letter_map.get(n%10));
			n = n/10;
			count++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCominations l = new LetterCominations();
		l.addVlaues();
		l.findNumberOfDigits(23);
		l.printCombinations();
	}

}
