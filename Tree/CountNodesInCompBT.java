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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int lnodes = countNodes(root.left);
        int rnodes = countNodes(root.right);

        return (1 + lnodes + rnodes);

    }
}

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

    private int findLeftHeight(TreeNode root) {
        int count = 1;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int findRightHeight(TreeNode root) {
        int count = 1;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        // check if all levels are completely filled
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if (lh == rh) {
            return ((int) (Math.pow(2, lh) - 1)); // using leftshit (1<<lh)-1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}