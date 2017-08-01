
class Node{
	int d;
	Node next;
	
	
	Node(int x){
		d = x;
		next = null;
	}
}
public class IntSlist {
	private Node first;
	private Node last;
	private int num;
	
	IntSlist(){
		first=null;
		last=null;
		num=0;
	}
	
	public Node[] find(int x, Node[] node) {
		//Find the node in Linked List
		node = new Node[2];
		node[0] = first;
		node[1] = last;
		while(node[0]!=null) {
			if(node[0].d==x) {
				break;
			}
			node[1]=node[0];
			node[0]=node[0].next;
		}
		return node;
		
	}
	public boolean contains(int x) {
		//Check if node is present in Linked List
		Node[] nodes = new Node[2];
		nodes = find(x,nodes);
		return (nodes[0]!=null?true:false);
		
	}
	public void add(int x) {
		//Add a new Node to the Linked List
		Node node=new Node(x);
		if(first!=null && last!=null) {
			last.next = node;
			last=node;
		}
		if(first==null && last==null) {
			first = last = node;
			
		}
		incsize();
	}
	
	public boolean remove(int x) {
		//Remove a Node from Linked List
		Node[] nodes = new Node[2];
		nodes = find(x, nodes);
		if(nodes!=null) {
			if(nodes[0]==first && nodes[0]==last) {
				first=null;
				last=null;
			}
			else if(nodes[0]==first) {
				first= nodes[0].next;
			}else if(nodes[0]==last) {
				nodes[1].next = null;
				last=nodes[1];
			}else{
				nodes[1].next = nodes[0].next;
			}
			decsize();
			return true;
		}
		return false;
	}
	
	public static void addNodes(IntSlist l1,IntSlist l2) {
		//Add two non-empty linked lists representing two non-negative integers.
		int carry =0;int total =0;int rem=0;
		IntSlist sum = new IntSlist();
		int len1 = length(l1);
		int len2 = length(l2);
		System.out.println("Length 1 "+len1);
		System.out.println("Length 2 "+len2);
		if(len1 > len2) {
			l2 = padding(l2,(len1-len2));
		}else if(len2 > len1) {
			l1 = padding(l1,(len2-len1));
		}
		l1.pLn();
		l2.pLn();
		Node list1 = l1.first;
		Node list2 = l2.first;
		while(list1!=null) {
			System.out.println("Adding Data1 "+list1.d +" with "+list2.d);
			total = carry + list1.d + list2.d;
			if(total>=9) {
				rem = total %10;
				carry = 1;
			}else {
				rem = total;
				carry = 0;
			}
			sum.add(rem);
			list1 = list1.next;
			list2 = list2.next;
		}
		if(carry ==1) {
			sum.add(1);
		}
		sum.pLn();
		
	}
	
	public IntSlist reverseSlist(IntSlist l) {
		//Reverse a Linked List
		Node c = l.first;
		l.last = l.first;
		while(c!=null) {
			Node n = c.next;
			if(n!=null) {
				Node t = n.next;
				n.next = c;
				c = n;
				n = t;
			}
		}
		l.first = c;
		l.last.next = null;
		return null;
	}
	
	public static IntSlist padding(IntSlist l,int diff) {
		for(int i=0;i<diff;i++) {
			Node n = new Node(0);
			l.last.next = n;
			l.last = n;
		}
		return l;
	}
	
	public static int length(IntSlist l) {
		int length=0;
		if(l.first==null)
			return 0;
		Node node = l.first;
		while(node!=null) {
			length++;
			node = node.next;
		}
		return length;
	}
	
	public void pLn() {
		Node n=first;
		while(n!=null) {
			System.out.print(n.d);
			if(n.next==null)
				System.out.print("->NIL");
			else
				System.out.print("->");
			n=n.next;
		}
		System.out.println("");
	} 
	
	public void incsize() {
		num++;
	}
	public void decsize() {
		num--;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntSlist s = new IntSlist();
		s.add(2);
		s.add(4);
		s.add(3);
		
		 s.pLn();
//		if(s.contains(4))
//			System.out.println("Node is present in the Linked List");
//		else
//			System.out.println("Node is not present in the Linked list. Try Inserting");
		 IntSlist s2 = new IntSlist();
//		 s2.add(4);
		 s2.add(5);
		 s2.add(6);
		 s2.add(4);
		 s2.pLn();
		 addNodes(s, s2);
	}
		 

}
