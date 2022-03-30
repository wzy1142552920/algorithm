package tree;

import org.junit.Test;

import java.util.Stack;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/3/30 21:53
 */
public class PreOrderTravel {

    /*
    * 前序遍历递归方式
    * */
    public void preOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            System.out.print(curNode.val + " ");
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }
}
