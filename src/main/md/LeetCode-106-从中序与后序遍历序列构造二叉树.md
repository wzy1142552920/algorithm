## LeetCode-106-从中序与后序遍历序列构造二叉树
```java
public TreeNode buildTree(int[] inorder, int[] postorder) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
    }
    return build(inorder, 0, inorder.length - 1, postorder, 0, inorder.length - 1, map);
}

private TreeNode build(int[] inorder, int inL, int inR, int[] postorder, int posL, int posR, HashMap<Integer, Integer> map) {
    TreeNode root = new TreeNode(postorder[posR]);
    if (inL == inR) {
        return root;
    }
    int index = map.get(postorder[posR]);
    TreeNode left = null;
    if (index != inL) {
        left = build(inorder, inL, index - 1, postorder, posL, posL + index - inL - 1, map);
    }
    TreeNode right = null;
    if (index != inR) {
        right = build(inorder, index + 1, inR, postorder, posL + index - inL, posR - 1, map);
    }
    root.left = left;
    root.right = right;
    return root;
}
```