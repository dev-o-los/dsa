import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  private void inorder(TreeNode node, List<Integer> result) {
    if (node == null)
      return;

    inorder(node.left, result);
    result.add(node.val);
    inorder(node.right, result);
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    return result;
  }
}

// iterative solution

class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;

    while (node != null || !stack.isEmpty()) {

      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      // print the root
      node = stack.pop();
      res.add(node.val);
      // move to right subtree;
      node = node.right;
    }

    return res;
  }
}

class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;

    while (node != null || !stack.isEmpty()) {

      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        // print the root
        node = stack.pop();
        res.add(node.val);
        // move to right subtree;
        node = node.right;
      }
    }

    return res;
  }
}