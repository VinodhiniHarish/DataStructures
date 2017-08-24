
public class Anagram {
	
	public void findAnagram(String first, String second) {
		int len_first = first.length();
		String temp = second;
		
		for(int i=0;i<first.length();i++) {
			char ch = first.charAt(i);
			if(second.indexOf(ch)!=-1) {
				second = second.substring(0,second.indexOf(ch)) + second.substring(second.indexOf(ch)+1,second.length());
			}
		}
		
		int diff = temp.length() - second.length();
		System.out.println((len_first-diff) + (temp.length() - diff));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagram a = new Anagram();
		a.findAnagram("cde", "abc");
	}

}
