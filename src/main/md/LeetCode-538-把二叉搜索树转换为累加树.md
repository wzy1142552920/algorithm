## LeetCode-538-把二叉搜索树转换为累加树
右中左遍历，没遍历一个节点，记录累加和pre
```java
int pre;
public TreeNode convertBST(TreeNode root) {
    pre = 0;
    travel(root);
    return root;
}

private void travel(TreeNode root) {
    if (root == null) {
        return;
    }
    travel(root.right);
//  pre += root.val;
//  root.val = pre;
    root.val += pre;
    pre = root.val;
    travel(root.left);
}
```