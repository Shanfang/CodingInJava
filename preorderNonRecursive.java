/*
implement binary tree preorder traversal in non-recursive way
with stack and ArrayList
*/
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	//constructor
	TreeNode(int x) {
	val = x;
	}
}

public class preorderNonRecursive {
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack  = new Stack<TreeNode>();
		List<Integer> preorder = new ArrayList<Integer>();

		if(root == null) {
			return preorder;
		}

		stack.push(root);
		while(!stack.empty()) {
			TreeNode node = stack.pop();
			preorder.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return preorder;
	}
}
