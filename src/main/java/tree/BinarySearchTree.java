package tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/4/12 23:30
 */
public class BinarySearchTree {

    /*插入*/
    public void insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        if (root.val > val) {
            insert(root.left, val);
        } else {
            insert(root.right, val);
        }
    }

    /*查找*/
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return find(root.left, val);
        } else {
            return find(root.right, val);
        }
    }

    /*最小值*/
    public TreeNode findMin(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    /*最大值*/
    public TreeNode findMax(TreeNode root) {
        if (root == null || root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    /*删除, 返回删除后的根节点*/
    public TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                TreeNode cur = root.right;
                while (cur != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        } else if (root.val > val) {
            root.left = delete(root.left, val);
        } else {
            root.right = delete(root.right, val);
        }
        return root;
    }
}

