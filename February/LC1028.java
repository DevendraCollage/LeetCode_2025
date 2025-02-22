/*
 * LC1028 - Recover a Tree From Preorder Traversal
 */

import javax.swing.tree.TreeNode;

class Solution {
    static int index = 0;
    static int n = 0;

    public static TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        n = traversal.length();
        return recur(traversal, 0);
    }

    public static TreeNode recur(String traversal, int depth) {
        // base case
        if (index >= n) {
            return null;
        }

        int count = 0;
        int tempIndex = index;

        // Count dashes to determine depth
        while (tempIndex < n && traversal.charAt(tempIndex) == '-') {
            count++;
            tempIndex++;
        }

        if (count != depth) {
            return null;
        }

        index = tempIndex;

        // Extract number
        int val = 0;
        while (index < n && Character.isDigit(traversal.charAt(index))) {
            val = val * 10 + (traversal.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(val);
        node.left = recur(traversal, depth + 1);
        node.right = recur(traversal, depth + 1);

        return node;
    }
}
