## LeetCode-501-二叉搜索树中的众数
利用二叉搜索树中序遍历递增的性质
```java
List<Integer> ans = new ArrayList<>();
int maxCount = Integer.MIN_VALUE;
int count;
TreeNode pre;

public int[] findMode(TreeNode root) {
    if (root == null) {
        return new int[]{};
    }
    travel(root);
    int[] res = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
        res[i] = ans.get(i);
    }
    return res;
}

private void travel(TreeNode root) {
    if (root == null) {
        return;
    }
    travel(root.left);
    if (pre == null || root.val != pre.val) {
        count = 1;
    } else {
        count++;
    }
    if (count == maxCount) {
        ans.add(root.val);
    } else if (count > maxCount) {
        ans.clear();
        ans.add(root.val);
        maxCount = count;
    }
    pre = root;
    travel(root.right);
}
```