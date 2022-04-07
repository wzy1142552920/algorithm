## LeetCode-1110-删点成林
后序遍历
```java
List<TreeNode> ans = new ArrayList<>();
Set<Integer> set = new HashSet<>();

public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    for (int d : to_delete) {
        set.add(d);
    }
    root = helper(root);
    if (root != null) {
        ans.add(root);
    }
    return ans;
}

private TreeNode helper(TreeNode root) {
    if (root == null) {
        return null;
    }
    root.left = helper(root.left);
    root.right = helper(root.right);
    if (set.contains(root.val)) {
        if (root.left != null) {
            ans.add(root.left);
        }
        if (root.right != null) {
            ans.add(root.right);
        }
        return null;
    }
    return root;
}
```