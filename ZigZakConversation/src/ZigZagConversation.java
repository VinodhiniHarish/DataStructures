
public class ZigZagConversation {
	
	public void printZigZag(String s, int n) {
		StringBuffer buff = new StringBuffer();
		char[] ch = new char[s.length()+1];
		for(int i=0;i<s.length();i++) {
			ch[i+1] = s.charAt(i);
		}
		
		int[] start = new int[n];
		for(int i=0;i<n;i++)
			start[i] = i+1;
		
		for(int i=0; i<start.length;i++) {
			int x = start[i];
			while(x < ch.length) {
				if(start[i] % 2 != 0) {
					System.out.print(ch[x]);
					buff.append(ch[x]);
					x = x + 4;
				}else {
					break;
				}
				
			}
			while(x < ch.length) {
				if(start[i] % 2 == 0) {
					System.out.print(ch[x]);
					buff.append(ch[x]);
					x = x +2;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversation z = new ZigZagConversation();
		System.out.println("String to be converted : PAYPALISHIRING");
		System.out.println("Converted String");
		z.printZigZag("PAYPALISHIRING", 3);
		
	}

}
