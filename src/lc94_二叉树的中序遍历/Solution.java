package lc94_二叉树的中序遍历;

import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        f(root, res);
        return res;
    }

    public void f(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        f(root.left, list);
        list.add(root.val);
        f(root.right, list);

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
