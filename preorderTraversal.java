/* 
implementing preorder traversal a binary tree in recursive way
divide and conquer
*/
import java.util.ArrayList;
//import java.util.List;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	//constructor
	TreeNode(int x) {
	val = x;
	}
}

public class preorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}

		ArrayList<Integer> left = preorderTraversal(root.left);
		ArrayList<Integer> right = preorderTraversal(root.right);

		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		return result;
	}
}
