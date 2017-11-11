
public class Median {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int[] result = new int[nums1.length + nums2.length];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                result[k++] = nums1[i++];
            }else{
                result[k++] = nums2[j++];
            }
        }
        while(i< nums1.length){
            result[k++] = nums1[i++];
        }
        while(j < nums2.length){
            result[k++] = nums2[j++];
        }
        if(result.length%2 != 0){
            return (float)result[result.length/2];
        }
        int sum = result[result.length/2-1] + result[result.length/2];
        return (float)sum/2;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Median m = new Median();
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(m.findMedianSortedArrays(nums1, nums2));
	}

}
