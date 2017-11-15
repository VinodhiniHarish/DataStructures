import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int[] perimeterTriangle(int[] nums){
        // Find the list of possible valid triangles that can be formed from the given array
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        int ws = 3;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i] + nums[i+1] > nums[i+2]){
                List<Integer> inner  = new ArrayList<Integer>();
                inner.add(nums[i]);
                inner.add(nums[i+1]);
                inner.add(nums[i+2]);
                outer.add(inner);
            }
        }
        
        // Find the result as per the given condition 
        Iterator<List<Integer>> outerIt = outer.iterator();
        List<Integer> innerIt;
        
        int[] result = new int[3];
        int max = Integer.MIN_VALUE;
        while(outerIt.hasNext()){
            innerIt = outerIt.next();
            int longestMaximumSide = innerIt.get(innerIt.size()-1);
            if(max == longestMaximumSide){
                //Criteria 2
                if(result[0] > innerIt.get(0) && result[1] > innerIt.get(1)){
                    return result;
                }else{
                    
                }
            }else if(longestMaximumSide > max){
                max = longestMaximumSide;
                result[0] = innerIt.get(0); result[1] = innerIt.get(1);
                result[2] = innerIt.get(2);
            }
        }
        
        if(outer.size() == 0){
            int[] r = {-1};
            return r;
        }
        return result;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        
        int[] r = perimeterTriangle(arr);
        for(int num : r){
            System.out.print(num + " ");
        }
    }
}