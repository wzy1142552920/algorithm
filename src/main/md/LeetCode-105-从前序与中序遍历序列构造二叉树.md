## LeetCode-105-从前序与中序遍历序列构造二叉树
```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);//记录中序遍历节点对应数组所在位置
    }
    return buildHelper(0, preorder.length, preorder, 0, inorder.length, inorder, map);
}

private TreeNode buildHelper(int preL, int preR, int[] preorder, int inL, int inR, int[] inorder, Map<Integer, Integer> map) {
    if (preL == preR) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[preL]);
    int index = map.get(preorder[preL]);
    int len = index - inL;
    TreeNode left = buildHelper(preL + 1, preL + len + 1, preorder, inL, index, inorder, map);
    TreeNode right = buildHelper(preL + len + 1, preR, preorder, index + 1, inR, inorder, map);
    root.left = left;
    root.right = right;
    return root;
}
```