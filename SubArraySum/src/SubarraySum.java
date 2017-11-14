import java.util.*;
public class SubarraySum {
	
	
	public int subarraySum1(int[] nums, int k) {
        int count =0;
        for(int ws = 1;ws<=nums.length;ws++){
            for(int i=0;i<nums.length;i++){
                if(i+ws <= nums.length){
                    int sum =0;
                    for(int j=i;j<i+ws;j++){
                        sum += nums[j];
                    }
                    if(sum == k){
                        count++;
                    }
                }
            }
        }
        return count;
    }
	
	public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubarraySum s = new SubarraySum();
		int[] nums = {1,1,1};
		int k=2;
		System.out.println(s.subarraySum(nums, k));
	}

}
