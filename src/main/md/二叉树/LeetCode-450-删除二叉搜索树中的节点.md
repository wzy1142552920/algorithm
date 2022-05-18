## LeetCode-450-删除二叉搜索树中的节点
分情况考虑：

1、如果二叉树中没有节点满足目标值，直接返回null

2、如果相等的节点是叶子节点，直接删除，返回null

3、如果相等的节点的左子节点不为空，右子节点为空，返回右子节点

4、如果相等的节点的右子节点不为空，左子节点为空，返回左子节点

5、如果相等的节点的左右子节点都不为空，将左子节点放到右子节点最左叶节点的左节点，返回右子节点

```java
public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
        return null;
    }
    if (root.val == key) {
        if (root.left != null &&  root.right == null) {
            return root.left;
        } else if (root.left == null && root.right != null) {
            return root.right;
        } else if (root.left == null && root.right == null) {
            return null;
        } else {
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = root.left;
            return root.right;
        }
    }
    if (root.val > key) {
        root.left = deleteNode(root.left, key);
    }
    if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
}
```
