
public class MaxHeap {
	
	protected IntArray heap;
	protected int pos;
	public static final int NULL = -99999999;
	
	public MaxHeap() {
		heap = new IntArray();
		pos = 0;
	}
	
	public MaxHeap(int[] a) {
		heap = new IntArray();
		pos = 0;
		buildHeapTopToBottom(a);
	}
	
	public int left(int x) {
		int n = x * 2;
		return (n>pos ? 0: n);
	}
	
	public int right(int x) {
		int n = x * 2 + 1;
		return (n > pos ? 0: n);
	}
	
	public int parent(int x) {
		int n = x/2;
		return (n >= 1 ? n: 0);
	}
	
	public int size() {
		return pos;
	}
	
	public boolean isEmpty() {
		return (pos == 0 ? true : false);
	}
	
	
	public boolean isParentBiggerThanChild(int p,int c) {
		if(heap.get(p) > heap.get(c))
			return true;
		return false;
	}
	
	public void buildHeapTopToBottom(int[] a) {
		for(int i=0;i<a.length;i++) {
			insert(a[i]);
		}
	}
	
	public void insert(int val) {
		heap.set(++pos, val);
		heapifyUp();
	}
	
	public void deleteTop() {
		if(pos == 1) {
			pos = 0;
		}else {
			swap(1,pos);
			--pos;
			heapifyDown();
		}
	}
	
	public void heapifyDown() {
		heapifyDown(1);
	}
	
	public void heapifyDown(int p) {
		while(true) {
			int m = minMax(p);
			if(m == 0)
				break;
			if(m!=0) {
				swap(p, m);
			}
			p = m;
		}
	}
	
	public int minMax(int x) {
		int left = left(x);
		int right = right(x);
		
		while(true) {
			if(left!=0 && right ==0) {
				return 0;
//				assert(false);
			}else if(left !=0 && right ==0) {
				boolean m = isParentBiggerThanChild(x, left);
				if(!m) {
					return left;
				}
			}else if(left!=0 && right!=0) {
				int c = right;
				if(heap.get(left) > heap.get(right)) {
					c = left;
				}
				if(heap.get(x) < heap.get(c)) {
					return c;
				}
//				return c;
			}
			else {
				return 0;
			}
		}
		
//		return 0;
	}
	
	public void heapifyUp() {
		int s = pos;
		while(true) {
			int p = parent(s);
			
			if(p == 0)
				break;
			boolean m = isParentBiggerThanChild(p, s);
			if(!m) {
				//Swap parent and child
				swap(p, s);
				s = p;
			}else {
				break;
			}
		}
	}
	
	public void swap(int p,int c) {
		int temp = heap.get(p);
		heap.set(p, heap.get(c));
		heap.set(c, temp);
	}
	
	public void printHeap() {
		for(int i=1;i<=pos;i++) {
			System.out.print(heap.get(i) + " ");
		}
		System.out.println("\n");
	}
	
	public void heapSort() {
		int t = pos;
		while(true) {
			if(pos == 0)
				break;
			swap(1,pos);
			pos--;
			heapifyDown(1);
		}
		pos = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7};
		MaxHeap m = new MaxHeap(a);
		System.out.println("Building a Max Heap");
		m.printHeap();
		System.out.println("Maximum element in the heap is "+m.heap.get(1));
		System.out.println("Delete Top");
		m.deleteTop();
		System.out.println("Heap after deleting the top");
		m.printHeap();
		m.heapSort();
		System.out.println("Heap After sorting");
		m.printHeap();
		
	}

}
