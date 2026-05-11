package lc105_从前序与中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(
                preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1
        );
    }

    public TreeNode build(
            int[] pre, int ps, int pe,
            int[] in, int is, int ie
    ) {
        if (ps > pe || is > ie) {
            return null;
        }
        //找根
        TreeNode root = new TreeNode(pre[ps]);
        int inRootIndex = inMap.get(root.val);
        int leftsize = inRootIndex - is;
        //递归左子树
        root.left = build(
                pre, ps + 1, ps + leftsize,
                in, is, inRootIndex - 1
        );
        //递归右子树
        root.right = build(
                pre, ps + leftsize + 1, pe,
                in, inRootIndex + 1, ie
        );

        //返回当前root
        return root;
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