/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);

        return (height != -1);
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        if (lh == -1 || rh == -1 || (Math.abs(lh - rh) > 1)) {
            return -1;
        }

        return (1 + Math.max(lh, rh));

    }
}