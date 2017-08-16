import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class node{
	protected int d;
	protected int depth;
	protected node parent;
	protected node left;
	protected node right;	
	
	node(int x){
		d = x;
		depth = 0;
		parent = null;
		left = null;
		right = null;
	}
}
public class IntBTree {
	
	private node root;
	private int num;
	private int height;
	static final int NULL = -99999999;
	IntUtil u = new IntUtil();
	
	public IntBTree() {
		root = null;
		num =0;
		height = 0;
	}
	
	public IntBTree(int[][] t) {
		this();
		buildTree(t);
	}
	
	public int height() {
		return height;
	}
	
	private int size() {
		return num;
	}
	
	public boolean isLeaf(node d) {
		return (d.left == null && d.right ==null ? true : false);
	}
	
	protected node isOneKid(node n) {
		if(n.left != null && n.right ==null)
			return n.left;
		else if(n.left == null && n.right != null)
			return n.right;
		return null;
	}
	
	
	protected node buildNode(int x) {
		node n = new node(x);
		incSize();
		return n;
	}
	
	public int incSize() {
		return ++num;
	}
	
	private void depth_r(node r) {
		if(r!=null) {
			if(r == root) {
				r.depth = 0;
			}else {
				r.depth = r.parent.depth + 1;
				if(r.depth > height) {
					height = r.depth;
				}
			}
			depth_r(r.left);
			depth_r(r.right);
		}
	}
	
	public void computeDepth() {
		depth_r(root);
	}
	
	private void buildTree(int[][] t) {
		int size = t.length;
		int max = 0;
		int min = 99999;
		//STEP 1: Find MAX
		for(int i=0; i<size ;i++) {
			int[] a = t[i];
			u.myassert(a.length == 3);
			
			for(int j = 0;j<a.length;++j) {
				if(a[j] > max)
					max = a[j];
				if((a[j]!=NULL) && (a[j] < min)) {
					min = a[j];
				}
				u.myassert(min >=0);
			}
		}
		// STEP 2: Build a tree
		node[] tn = new node[max + 1];
		for(int i =0;i<size;i++) {
			int[] a = t[i];
			//father
			if(tn[a[0]] == null) {
				tn[a[0]] = buildNode(a[0]);
			}else if((tn[a[0]].left!=null) || (tn[a[0]].right!=null)) {
				System.out.println(a[0] + " has already a left or right child. Bug in Input");
				root = null;
				num = 0;
				return;
			}
			//Left Kid
			if(a[1]!=NULL) {
				if(tn[a[1]] == null)
					tn[a[1]] = buildNode(a[1]);
				tn[a[0]].left = tn[a[1]];
				tn[a[1]].parent = tn[a[0]];
			}
			
			//Right Kid
			if(a[2]!=NULL) {
				if(tn[a[2]] == null)
					tn[a[2]] = buildNode(a[2]);
				tn[a[0]].right = tn[a[2]];
				tn[a[2]].parent = tn[a[0]];
			}
		}
		
		//STEP 3: Find the node that has no father
		root = null;
		for(int i=0;i<tn.length;i++) {
			if((tn[i])!=null && (tn[i].parent == null)) {
				if(root!= null) {
					System.out.println("Two Roots " + tn[i].d + " Bug in input");
					root = null;
					num = 0;
					return;
				}
				root = tn[i];
			}
		}
	}
	
	private void preorder_r(node r,int[] a, int k) {
		
	}
	
	
	public void writeDot(String fname, String info) {
		if(root!=null) {
			try {
				FileWriter o = new FileWriter(fname);
				computeDepth();
				o.write("### Vinodhini Asok Kumar ###\n");
				o.write("### dot - Tpdf" + fname +" -o "+ fname +".pdf\n");
				o.write("digraph g{\n");
				
				/* make label */
					
				String label = " label = ";
				label = label + "\" " + " # nodes = " + size() + " # height = " + height() ;
				if (info != null) {
				label = label + " " + info ;
				}
				label = label + "\"\n";
				
				o.write(label);
				Queue<node> q = new LinkedList();
				q.add(root);
				int nk = 0; // null kount
				while (q.isEmpty() == false) {
				node n = q.remove();
				if (n.left == null && n.right == null) {
				o.write(" " + n.d + "[xlabel = \"" + n.depth + "\"]");
				continue;
				}
				if (n.left == null) {
				String nulls = " null" + nk++;
				o.write(nulls + " [shape=point style=invis]\n");
				o.write(" " + n.d + " ->" + nulls + " [color=red style=invis]\n");
				} else {
				o.write(" " + n.d + " ->" + n.left.d + " [color=red]\n");
				o.write(" " + n.d + "[xlabel = \"" + n.depth + "\"]");
				q.add(n.left);
				}
				if (n.right == null) {
					String nulls = " null" + nk++;
					o.write(nulls + " [shape=point style=invis]\n");
					o.write(" " + n.d + " ->" + nulls + " [color=blue style=invis]\n");
				}
				else {
					o.write(" " + n.d + " ->" + n.right.d + " [color=blue]\n");
					o.write(" " + n.d + "[xlabel = \"" + n.depth + "\"]");
					q.add(n.right);
				}
				}
				o.write("}\n");
				o.close();
				System.out.println("You can see dot file at " + fname);
				System.out.println("Run the following command to get pdf file");
				System.out.println("dot -Tpdf " + fname + " -o " + fname + ".pdf");
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t = {
				{6,2,7},
				{2,1,4},
				{7, IntBTree.NULL,9},
				{4,3,5},
				{8,8,IntBTree.NULL},
		};
		
		int[][] t1 = {
				{2,1,4},
				{4,3,5},
				{9,8,IntBTree.NULL},
				{7,IntBTree.NULL,9},
				{6,2,7},
				{10,2,7}
		};
		
		IntBTree bt = new IntBTree(t1);
		bt.writeDot("/home/vinu/BinaryTree1", null);
	}

}
