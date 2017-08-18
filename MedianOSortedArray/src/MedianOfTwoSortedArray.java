
public class MedianOfTwoSortedArray {
	
	public float findMedian(int[] a,int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0,j=0,k=0;
		while(i<a.length && j<b.length) {
			if(a[i] < b[j]) {
				c[k] = a[i];
				k++;
				i++; 
			}
			else if(a[i] > b[j] ) {
				c[k] = b[j];
				k++;
				j++;
			}
		}
		while(i<a.length) {
			c[k] = a[i];
			k++;
			i++;
		}
		while(j < b.length) {
			c[k] = b[j];
			k++;
			j++;
		}
		
		int len = c.length;
		float median;
		if(len%2 == 0) {
			median = c[len/2 -1 ] + c[len/2 ];
			median = median / 2;
		}else {
			median = c[len/2];
		}
		return median;
	}

	public void printLn(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2};
		int[] b = {3, 4};
		MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
		System.out.println("Array 1");
		m.printLn(a);
		System.out.println("Array 2");
		m.printLn(b);
		System.out.println("Median of Two arrays:");
		System.out.println(m.findMedian(a,b));
	}

}
