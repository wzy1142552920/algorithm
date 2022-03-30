package tree;

import org.junit.Test;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/3/30 21:44
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
