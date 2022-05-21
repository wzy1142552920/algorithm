## LeetCode-968-监控二叉树

贪心思路：

从叶子节点往根节点考虑，每隔一层放摄像头

定义节点三个状态

0 - 无覆盖
1 - 有摄像头
2 - 有覆盖

```java
int ans = 0;

public int minCameraCover(TreeNode root) {
    if (camera(root) == 0) {
        ans++;
    }
    return ans;
}

private int camera(TreeNode root) {
    /*
    *   0 表示无覆盖
        1 表示有摄像头
        2 表示有覆盖
    * */
    if (root == null) {
        return 2;
    }
    int left = camera(root.left);
    int right = camera(root.right);
    if (left == 2 && right == 2) {
        return 0;
    } else if (left == 0 || right == 0) {
        ans++;
        return 1;
    } else {
        return 2;
    }
}
```