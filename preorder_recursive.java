/* 
implementing preorder traversal a binary tree in recursive way
divide and conquer
*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	//constructor
	TreeNode(int x) {
	val = x;
	}
}

public class preorder_recursive {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}

		ArrayList<Integer> left = preorderTraversal(root.left);
		ArrayList<Integer> right = prerderTraversal(root.right);

		result.add(root.val);
		result.add(left);
		result.add(right);
		return result;
	}
}
