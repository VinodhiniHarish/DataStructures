
public class MergeSort {
	
	public static void merge(int[] left, int[] right, int[] a) {
		int i=0,j=0,k=0;
		int left_len = left.length;
		int right_len = right.length;
		while(i<left_len && j<right_len) {
			if(left[i] < right[j]) {
				a[k]=left[i];
				k++;
				i++;
			}else if(right[j] < left[i]) {
				a[k]=right[j];
				k++;
				j++;
			}
		}
		while(i<left_len) {
			a[k]=left[i];
			k++;
			i++;
		}
		while(j<right_len) {
			a[k] = right[j];
			k++;
			j++;
		}
//		System.out.println("Merged Array Size");
//		printLn(a);
	}
	
	public static void mergeSort(int[] a) {
		int n = a.length;
		int mid = n/2;
		int[] left =  new int[mid];
		int[] right = new int[n-mid];
		if(n<2)
			return;
		for(int i=0;i<mid;i++)
			left[i]=a[i];
		for(int j=mid;j<n;j++)
			right[j-mid]=a[j];
		
		mergeSort(left);
		mergeSort(right);

		merge(left,right,a);
		
	}
	
	public static void printLn(int[] a) {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {6,2,3,1,9,10,15,13,12,17};
		System.out.println("Array Before sorting");
		
		MergeSort m = new MergeSort();
		m.printLn(a);
		mergeSort(a);
		System.out.println("Array After sorting");
		m.printLn(a);
	}

}
