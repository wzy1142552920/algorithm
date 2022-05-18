## LeetCode-669.-修剪二叉搜索树
```java
public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) {
        return null;
    }
    //当前节点小于low，则左子树的节点值都会小于low，舍弃，修剪右子树
    if (root.val < low) {
        return trimBST(root.right, low, high);
    }
    //当前节点大于high，则右子树的节点值都会大于low，舍弃，修剪左子树
    if (root.val > high) {
        return trimBST(root.left, low, high);
    }
    //当前节点满足，递归修剪左右节点
    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);
    return root;
}
```