
public class SumOfArrayElements {
	
	public void findSum(int[] a) {
		int sum =0;
		for(int i=0;i<a.length-1;i++) {
//			sum =0;
			for(int j=i+1;j<a.length;j++) {
				if(a[i] < a[j])
					sum = sum + a[i] +a[j];
				else if(i!=0) {
					if(a[i-1] < a[i] && a[j] < a[i]) {
						sum = sum + a[i] +a[j];
					}
				}
					
				
			}
			
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5,6,7,6,5};
		SumOfArrayElements s = new SumOfArrayElements();
		s.findSum(a);
	}

}
