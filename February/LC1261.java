/*
 * LC1261 - Find Elements in a Contaminated Binary Tree
 */

import java.util.HashSet;

import javax.swing.tree.TreeNode;

class FindElements {

    static HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    public static boolean find(int target) {
        return set.contains(target);
    }

    public static void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        root.val = val;
        set.add(val);
        dfs(root.left, 2 * val + 1);
        dfs(root.right, 2 * val + 2);
    }
}