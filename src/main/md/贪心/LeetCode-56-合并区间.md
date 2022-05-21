## LeetCode-56-合并区间
贪心思路：
按照区间左位置递增排序，初始end位置为第一个区间右位置

遍历数组，如果当前区间左位置大于end，记录区间（start, end）,更新start，end

```java
public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> list = new ArrayList<>();
    int start = intervals[0][0];
    int end = intervals[0][1];
    int len = intervals.length;
    for (int i = 1; i < len; i++) {
        if (intervals[i][0] > end) {
            list.add(new int[]{start, end});
            start = intervals[i][0];
        }
        end = Math.max(end, intervals[i][1]);
    }
    list.add(new int[]{start, end});
    return list.toArray(new int[list.size()][]);
}
```