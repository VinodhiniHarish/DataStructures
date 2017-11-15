import java.util.*;
public class Range {
	
	static List<Integer> startList = new ArrayList<Integer>();
	static List<Integer> endList = new ArrayList<Integer>();
	
	public static void add(int start, int end) {
		startList.add(start);
		endList.add(end);
	}
	public static int maxOverlap() {
		int maxEmployees =1, employees = 1;
		int size = startList.size();
		
		Collections.sort(startList);
		Collections.sort(endList);
		
		int i=1,j=0;
		while(i<size && j<size) {
			if(startList.get(i) <= endList.get(j)) {
				employees++;
				maxEmployees = Math.max(employees, maxEmployees);
				i++;
			}else {
				employees--;
				j++;
			}
		}
		return maxEmployees;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add(1,2);
		add(2,3);
		add(3,4);
		System.out.println(maxOverlap());
	}

}
