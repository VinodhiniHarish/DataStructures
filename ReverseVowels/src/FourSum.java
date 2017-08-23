
public class FourSum {
	int[] a = { 1, 0, -1, 0, -2, 2 };
	
	public void find4sum(int sum) {
		for(int i=0;i<a.length-3;i++) {
			for(int j=i+1;j<a.length-2;j++) {
				for(int k=j+1;j<a.length-1;k++) {
					for(int m=k+1;k<a.length;m++) {
						if(a[i] + a[j] + a[k] + a[m] == sum) {
							System.out.println(a[i] +" " + a[j] +" " + a[k] +" " + a[m] );
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum f = new FourSum();
		f.find4sum(0);
	}

}
