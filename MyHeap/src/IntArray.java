
public class IntArray {
	
	protected int[] darray;
	protected int capacity;
	protected int pos;
	
	public IntArray() {
		this(16);
	}
	
	public IntArray(int s) {
		allocate(s);
	}
	
	public void allocate(int s) {
		darray = new int[s];
		capacity = s;
		pos = 0;
	}
	
	public void grow(int s) {
		int[] ta = darray;
		int ns = capacity;
		int ts = capacity;
		
		do {
			ns = ns * 2;
		}while(s >= ns);
		
		allocate(ns);
		for(int i=0;i<ts;i++) {
			darray[i] = ta[i];
		}
	}
	
	public void set(int s, int val) {
		if(s < 0) {
			assert(false);
		}
		
		if(s <= capacity) {
			darray[s] = val;
		}else {
			grow(s);
			darray[s] = val;
		}
		pos++;
		
	}
	
	public int get(int pos) {
		if(pos > 0) {
			return darray[pos];
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntArray a = new IntArray();
		a.set(4, 4000);
		a.set(89, 8000);
		a.set(300, 300000);
		a.set(1000, 100000);
		
		System.out.println(a.get(4));
		System.out.println(a.get(89));
		System.out.println(a.get(300));
		System.out.println(a.get(1000));
	}

}
