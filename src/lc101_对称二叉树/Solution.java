package lc101_对称二叉树;


public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {

        // 都为空
        if (left == null && right == null) {
            return true;
        }

        // 一个为空
        if (left == null || right == null) {
            return false;
        }

        // 值不相等
        if (left.val != right.val) {
            return false;
        }

        // 镜像比较
        return check(left.left, right.right)
                && check(left.right, right.left);
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