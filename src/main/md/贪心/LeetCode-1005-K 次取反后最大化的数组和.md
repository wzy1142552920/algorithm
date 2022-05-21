## LeetCode-1005-K 次取反后最大化的数组和

贪心思路：
排序数组，遍历数组，如果小于零且k大于零，k--，加该数的相反数，同时修改当前位置的数为对应的相反数

再次排序数组

如果k > 0 && k % 2 == 1

将累加和中减去2倍的最小值即为最终的结果

```java
public int largestSumAfterKNegations(int[] nums, int k) {
    int len = nums.length;
    int ans = 0;
    Arrays.sort(nums);
    for (int i = 0; i < len; i++) {
        if (nums[i] < 0 && k > 0) {
            ans -= nums[i];
            k--;
            nums[i] = -nums[i];
        } else {
            ans += nums[i];
        }
    }
    if (k > 0 && k % 2 == 1) {
        Arrays.sort(nums);
        ans -= 2 * nums[0];
    }
    return ans;
}
```

