package lc114_二叉树展开为链表;

public class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先展开左右子树
        dfs(root.left);
        dfs(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 左子树为空就不用拼接
        if (left == null) {
            return;
        }
        // 左子树移到右边
        root.right = left;
        root.left = null;
        // 找左链最后一个节点
        TreeNode cur = left;
        while (cur.right != null) {
            cur = cur.right;
        }
        // 接上原来的右子树
        cur.right = right;
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