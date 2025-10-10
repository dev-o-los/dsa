import javax.swing.tree.TreeNode;

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDia = new int[1];// passing reference so that maxDia changes otherwise only a copy will be passed
        findHeight(root, maxDia);
        return maxDia[0];
    }

    private int findHeight(TreeNode root, int maxDia[]) {
        if (root == null)
            return 0;

        int lh = findHeight(root.left, maxDia);
        int rh = findHeight(root.right, maxDia);
        maxDia[0] = Math.max(maxDia[0], lh + rh);
        return (1 + Math.max(lh, rh));
    }

}