package lc226_翻转二叉树;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public boolean reverse(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (reverse(root.left) && reverse(root.right)) {
            TreeNode node = root.right;
            root.right = root.left;
            root.left = node;
        }
        return true;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}