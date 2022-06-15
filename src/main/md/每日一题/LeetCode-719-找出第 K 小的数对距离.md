## LeetCode-719-找出第 K 小的数对距离
思路：
1、排序数组;
2、数对距离在 0 到 nums[n - 1] - nums[0]范围内；
3、二分选取距离mid，计算距离小于等于mid的数对数cnt，如果cnt < k, 距离在大于mid范围继续找，否则在小于mid范围找
4、对于计算cnt，采用双指针的方法
```java
// 二分查找
public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int len = nums.length;
    int l = 0;
    int r = nums[len - 1] - nums[0];
    while (l <= r) {
        int mid = (l + r) >> 1;
        if (cal(nums, mid) >= k) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return l;
}

// 双指针
private int cal(int[] nums, int x) {
    int res = 0;
    int len = nums.length;
    for (int i = 0, j = 1; i < nums.length; i++) {
        while (j < len && nums[j] - nums[i] <= x) {
            j++;
        }
        res += j - i - 1;
    }
    return res;
}
```