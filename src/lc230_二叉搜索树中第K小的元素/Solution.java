package lc230_二叉搜索树中第K小的元素;

public class Solution {
    int count = 0;
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        get(root, k);
        return res;
    }


    public void get(TreeNode root, int k) {
        if (root == null || count > k) {
            return;
        }
        if (root.left != null) {
            get(root.left, k);
        }
        count++;
        if (count == k) {
            res = root.val;
        }
        get(root.right, k);
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
