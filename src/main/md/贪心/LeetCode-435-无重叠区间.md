## LeetCode-435-无重叠区间

贪心思路：
按照区间右位置递增排序，取第一个右边界，遍历区间，如果区间的左位置小于右边界，计数加一，否则，更新右边界

```java
public int eraseOverlapIntervals(int[][] intervals) {
    int len = intervals.length;
    int ans = 0;
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int index = intervals[0][1];
    for (int i = 1; i < len; i++) {
        if (intervals[i][0] < index) {
            ans++;
        } else {
            index = intervals[i][1];
        }
    }
    return ans;
}
```