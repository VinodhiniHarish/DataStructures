///Longest Subarray having sum of elements atmost ‘k’
//Input : arr[] = {1, 2, 1, 0, 1, 1, 0}, 
//           k = 4
//Output : 5
//Explanation:
// {1, 2, 1} => sum = 4, length = 3
// {1, 2, 1, 0}, {2, 1, 0, 1} => sum = 4, length = 4
// {1, 0, 1, 1, 0} =>5 sum = 3, length = 5

public class LongestSubarray {

	public int findLongest(int[] a, int num) {
		int sum = 0, count =0, max = 0;
		for(int i=0;i<a.length;i++) {
			sum = sum + a[i];
			count++;
			if(sum == num) {
				if(max < sum) {
					max = count;
					i = count - 2;
					sum = 0;
					count = 0;
				}
			}else if(sum > 4){
				sum = 0;
				count = 0;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubarray l = new LongestSubarray();
		int[] a = { 1, 0, 1, 0, 1, 1, 2 };
		System.out.println(l.findLongest(a, 4));
	}

}
