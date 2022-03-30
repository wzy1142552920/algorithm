package tree;

import java.util.Stack;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/3/30 22:24
 */
public class InOrderTravel {

    public void inOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root.left);
        System.out.print(root.val + " ");
        inOrderRecursion(root.right);
    }

    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }
}
