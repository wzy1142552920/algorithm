## LeetCode-108-将有序数组转换为二叉搜索树
中间位置作为根节点，左右区间递归
```java
public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length);
}

private TreeNode build(int[] nums, int start, int end) {
    if (start == end) {
        return null;
    }
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(nums, start, mid);
    root.right = build(nums, mid + 1, end);
    return root;
}
```