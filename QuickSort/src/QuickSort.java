
public class QuickSort {
	
	public static void quicksort(int[] a,int start,int end) {
		if(start>=end)
			return;
		int pIndex = partition(a, start, end);
		quicksort(a, start, pIndex-1);
		quicksort(a,pIndex+1, end);
		
	}
	
	public static void printLn(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"->");
		}
		System.out.print("NIL");
		System.out.println("\n");
	}
	
	public static int partition(int[] a,int start,int end) {
		int pivot = a[end];
		int pIndex = start;
		int i;
		for(i=start;i<=end-1;i++) {
			
			if(a[i]<pivot) {
				a = swap(a,i, pIndex);
				pIndex++;
			}
		}
		a = swap(a, i,pIndex);
		return pIndex;
	}

	public static int[] swap(int[] a,int i,int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort q = new QuickSort();
		int[] a = {6,2,3,1,9,10,15,13,12,17};
		System.out.println("Array before sorting");
		q.printLn(a);
		quicksort(a,0,a.length-1);
		System.out.println("After quick sort");
		printLn(a);
	}

}
