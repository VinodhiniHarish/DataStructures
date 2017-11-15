
public class QuickSort {
	
	public static int findKthLargest(int[] nums, int start, int end,int k){
		while(true) {
			if(start == end){
				return nums[start];
			 }
	         int pIndex = partition(nums, start, end);
	         if(pIndex == k)
	            return nums[k];
	          else if(k < pIndex) {
	            end = pIndex -1;
	          }else {
	            start = pIndex + 1;
	          }
		}
        
    }
    public static int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int pIndex = start;
        for(int i= start; i<=end-1;i++){
            if(nums[i] < pivot){
                nums = swap(nums, i, pIndex);
                pIndex++;
            }
        }
        nums = swap(nums, pIndex, end);
        return pIndex;
    }
    
    public static int[] swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort q = new QuickSort();
		int[] nums = {3,3,3,3,4,3,3,3,3};
		
		int res = findKthLargest(nums,0, nums.length-1, nums.length-9);
		
		System.out.println(res);
	}

}
