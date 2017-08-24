
public class MaximumSubArr {
	
	int[] a = {-2, 1, -3, 4, -1,2, 1, -5, 4 };
	
	public void findMaxSubArray() {
		int max = 0, sum =0,t =0;
		int[] arrIndex = new int[2];
		for(int i=0;i<a.length-1;i++) {
			sum = a[i];
			for(int j=i+1; j<a.length; j++) {
				sum = sum + a[j];
				if(max < sum) {
					max = sum;
					arrIndex[0] = i;
					arrIndex[1] = j;
				}
			}
		}
		System.out.println("Max Vlaue " + max);
		for(int i=arrIndex[0];i<=arrIndex[1];i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubArr m = new MaximumSubArr();
		m.findMaxSubArray();
	}

}
