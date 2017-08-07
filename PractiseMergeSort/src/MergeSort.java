
public class MergeSort {
	
	public void sort(int[] a) {
		int n = a.length;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		if(n < 2)
			return;
		for(int i=0;i<mid;i++)
			left[i] = a[i];
		for(int i=mid;i<n;i++)
			right[i-mid] = a[i];
		
		sort(left);
		sort(right);
		merge(left,right, a);
	}

	public void merge(int[] left,int[] right,int [] a) {
		int i=0,j=0,k=0;
		int left_len = left.length;
		int right_len = right.length;
		
		while(i< left_len && j<right_len) {
			if(left[i] < right[j]) {
				a[k++]=left[i++];
			}else if(left[i] > right[j]) {
				a[k++] = right[j++];
			}
		}
		while(i<left_len) {
			a[k++] = left[i++];
		}
		while(j<right_len) {
			a[k++] = right[j++];
		}
	}
	
	public void printLn(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort m = new MergeSort();
		int[] a = {2,9,4,1,10,3,7,5,8};
		System.out.println("Array Before Sorting");
		m.printLn(a);
		m.sort(a);
		System.out.println("Array after sorting");
		m.printLn(a);
		
	}

}
