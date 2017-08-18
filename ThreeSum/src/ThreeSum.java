import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> l = new ArrayList<Integer>();
	public void find3Sum(int[] a,int sum) {
		for(int i=0;i<a.length-2;i++) {
			for(int j= i+1; j<a.length-1;j++) {
				for(int k = j+1;k<a.length;k++) {
					if(a[i] + a[j] + a[k] == sum) {
						System.out.println(a[i] + " " + a[j] + " " + a[k]);
						l.add(a[i]);
						l.add(a[j]);
						l.add(a[k]);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1, 0, 1, 2, -1, -4};
		ThreeSum s = new ThreeSum();
		s.find3Sum(a, 0);
	}

}
