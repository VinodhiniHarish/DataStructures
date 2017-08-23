
public class ReverseVowels {
	
	public void reverseVowels(String s){
        char[] vowels = { 'a' , 'e' ,'i' , 'o' , 'u'};
        String v = "aeiou";
        StringBuffer buff = new StringBuffer(v);
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length-1;
        while(i < j ){
            if(v.indexOf(ch[i])!=-1){
                if(v.indexOf(ch[j]) !=-1){
                    // Swap
                    ch = swap(i,j,ch);
                    i++;
                    j--;
                }else {
                j--;
                }
            }else if(v.indexOf(ch[j])!=-1) {
            	i++;
            }else {
            	i++;
            	j--;
            }
        }
        System.out.println("String after reversing the Vowels \n"+ new String(ch) );
    }
	
	public char[] swap(int i, int j, char[] ch){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseVowels rv = new ReverseVowels();
		rv.reverseVowels("thomas");
	}

}
