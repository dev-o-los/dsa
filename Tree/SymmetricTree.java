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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null)
            return true;
        if (leftTree == null || rightTree == null)
            return false;
        if (leftTree.val != rightTree.val)
            return false;

        return isMirror(leftTree.left, rightTree.right) && isMirror(leftTree.right, rightTree.left);
    }
}