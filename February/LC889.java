/*
 * LC889 - Construct Binary Tree from Preorder and Postorder Traversal
 */

import java.util.HashMap;

import javax.swing.tree.TreeNode;

class Solution {
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return recur(0, n - 1, 0, n - 1, preorder, postorder);
    }

    public static TreeNode recur(int i1, int i2, int j1, int j2, int preorder[], int postorder[]) {
        // base case
        if (i1 > i2 || j1 > j2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i1]);
        if (i1 == i2) {
            return root;
        }
        // find preorder[i1+1] in postorder
        int r = map.get(preorder[i1 + 1]);
        int size = r - j1 + 1;
        root.left = recur(i1 + 1, i1 + size, j1, r, preorder, postorder);
        root.right = recur(i1 + size + 1, i2, r + 1, j2 - 1, preorder, postorder);
        return root;
    }
}