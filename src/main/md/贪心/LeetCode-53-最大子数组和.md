## LeetCode-53-最大子数组和

贪心思路：累加数组元素，当累加和为负值时，累加值清零继续累加
```java
public int maxSubArray(int[] nums) {
    int ans = Integer.MIN_VALUE;
    int count = 0;
    for (int n : nums) {
        count += n;
        if (count > ans) {
            ans = count;
        }
        if (count < 0) {
            count = 0;
        }
    }
    return ans;
}
```