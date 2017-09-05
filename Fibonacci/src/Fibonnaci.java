
public class Fibonnaci {
	
	public void fibonacci(int n) {
		int f1 =0,f2= 1;
		int fib = 0;
		if(n>=2) {
			System.out.print(f1 +" ");
			System.out.print(f2 +" ");
		}
		while(n!=0) {
			fib = f1 + f2;
			System.out.print(fib +" ");
			f1 = f2;
			f2 = fib;
			
			n--;
		}
	}
	
	public int fibonacciR(int n) {
		if(n ==0)
			return 0;
		if(n==1)
			return 1;
		return fibonacciR(n-1) + fibonacciR(n-2);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonnaci f = new Fibonnaci();
		//f.fibonacci(8);
		System.out.println(f.fibonacciR(1000) + " ");
	}

}
