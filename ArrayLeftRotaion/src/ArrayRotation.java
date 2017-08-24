
public class ArrayRotation {
	int[] a = { 1, 2, 3, 4, 5 };
	
	public void rotateArray(int nr) {
		while(nr > 0) {
			int temp = a[0];
			for(int i=1;i<a.length;i++) {
				a[i-1] = a[i];
			}
			a[a.length-1] = temp; 
			nr--;
		}
	}
	
	public void printLn() {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayRotation ar = new ArrayRotation();
		ar.rotateArray(5);
		ar.printLn();
	}

}
