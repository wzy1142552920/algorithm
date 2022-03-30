package tree;

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

    }
}
