package tree;

import java.util.Stack;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/3/30 22:45
 */
public class PostOrderTravel {

    public void postOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.val + " ");
    }

    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 使用指针  记录遍历到哪个节点
        TreeNode p = root;
        // 记录上一次访问的节点
        TreeNode prev = null;
        while (p != null || !stack.isEmpty()) {
            // 入栈  把当前能读到的所有左孩子 存入栈中
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            // 出栈 弹出栈顶元素  并找到其右孩子
            if (!stack.isEmpty()) {
                // 节点出栈的逻辑有两种情况：
                // 1）当前节点是叶子节点
                // 2）上一次出栈的节点是当前节点的右孩子
                p = stack.pop();
                if (p.right == null || prev == p.right) {
                    System.out.print(p.val + " ");
                    prev = p;
                    p = null;
                } else {
                    // 不满足出栈条件  是因为节点有右孩子  且右孩子没有被访问到
                    stack.push(p);
                    p = p.right;
                }
            }
        }
    }
}
