## LeetCode-376-摆动序列.md

贪心：统计所有峰值和谷值

```java
public int wiggleMaxLength(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
        return len;
    }
    int ans = 1;
    int pre = 0;
    for (int i = 1; i < len; i++) {
        int cur = nums[i] - nums[i - 1];
        if (cur > 0 && pre <= 0 || cur < 0 && pre >= 0) {
            ans++;
            pre = cur;
        }
    }
    return ans;
}
```