## LeetCode-45-跳跃游戏 II
贪心思路：
考虑每一步能到的最大范围：
coding：遍历数组，记录当前位置能够到达的位置，并记录最大值，当遍历到对应的最大值时，更新下一次能够到达的最远位置

```java
public int jump(int[] nums) {
    int len = nums.length;
    int ans = 0;
    int curDis = 0;
    int nexDis = 0;
    // 遍历的最后的位置是倒数第二个位置，如果已经到最后一个位置了，已经满足要求到达终点
    for (int i = 0; i < len - 1; i++) {
        nexDis = Math.max(nexDis, i + nums[i]);
        if (i == curDis) {
            curDis = nexDis;
            ans++;
        }
    }
    return ans;
}
```