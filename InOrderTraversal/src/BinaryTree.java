import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		val = x;
	}
}
public class BinaryTree {
	
public static List<Integer> inorderTraversal(TreeNode root) {
        
        return inOrderHelper(root, new ArrayList<Integer>());
    }
    
    public static List<Integer> inOrderHelper(TreeNode node, List<Integer> list){
        if(node == null)
            return null;
        inOrderHelper(node.left, list);
        list.add(node.val);
        inOrderHelper(node.right,list);
        return list;
    }
    
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = isValidBSTHelper(root, new ArrayList<Integer>());
        Iterator<Integer> it = list.iterator();
        int[] arr = new int[list.size()];
        int[] arr2 = new int[list.size()];
        int i=0;
        
        while(!it.hasNext()) {
        	int n = it.next();
        	arr[i] = n;
        	arr2[i] = n;
        	i++;
        }
        Arrays.sort(arr2);
        return (arr==arr2 ? true:false);
    }
    
    public List<Integer> isValidBSTHelper(TreeNode node, List<Integer> list){
    	if(node == null)
    		return null;
    	isValidBSTHelper(node.left,list);
    	list.add(node.val);
    	isValidBSTHelper(node.right, list);
    	return list;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(6);
		
		List<Integer> list = inorderTraversal(root);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
