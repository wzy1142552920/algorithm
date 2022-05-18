## LeetCode-55-跳跃游戏
贪心思路：
遍历数组，更新能够到达的最远位置，如果当前位置不在已遍历最远位置内，则返回false
```java
public boolean canJump(int[] nums) {
    int len = nums.length;
    int maxRight = 0;
    for (int i = 0; i < len; i++) {
        if (maxRight < i) {
            return false;
        }
        maxRight = Math.max(maxRight, i + nums[i]);
    }
    return true;
}
```