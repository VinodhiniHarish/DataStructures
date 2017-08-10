
class Node{
	int d;
	Node next;
	
	public Node(int d) {
		this.d = d;
		next = null;
	}
}

public class LinkedList {
	private Node first;
	private Node last;
	
	public LinkedList(){
		first = last = null;
	}
	
	public void addNode(int d) {
		Node n = new Node(d);
		if(first == null && last ==null) {
			first = last = n;
		}else {
			last.next = n;
			last = n;
		}
		
	}
	
	public void reverse() {
		Node c= first;
		if(c!= null) {
			last = first;
			Node n = c.next;
			while(n!=null) {
				Node t = n.next;
				n.next = c;
				c = n;
				n = t;
			}
			last.next = null;
			first = c;
		}
	}
	
	public int size() {
		Node t = first;
		int count =0;
		while(t!=null) {
			count++;
			t = t.next;
		}
		return count;
	}
	
	public void reverseByGroup(int k) {
		if(k!=size()) {
			Node c = first;
			Node m = first;
			if(c!=null) {
				Node n = c.next;
				while(k!=0 && n!=null) {
					Node t = n.next;
					n.next = c;
					c = n;
					n = t;
					k--;
				}
				m.next = n;
			}
			first = c;
		}else if(k == size()){
			reverse();
		}
	}
	
	public void printLn() {
		Node t = first;
		while(t!=null) {
			System.out.print(t.d+"->");
			t = t.next;
		}
		System.out.print("NIL");
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		l.addNode(1);
		l.addNode(2);
		l.addNode(3);
		l.addNode(4);
		l.addNode(5);
		l.printLn();
		int k = 2;
		System.out.println("Reversing the Linked List by Group");
		l.reverseByGroup(k);
		l.printLn();
		System.out.println("Reversing the Linked List");
		l.reverse();
		l.printLn();
	}

}
