## LeetCode-452-用最少数量的箭引爆气球
贪心思路：
将所有的气球按照右边界递增排序，初始情况从第一个球的右边界射出一支箭，依次遍历数组气球，如果气球的左边界不在射出箭的范围内，再以该气球右边界射出下一支箭，依次类推

由于输入的气球边界值在-2^31 <= xstart < xend <= 2^31 - 1范围，所以排序不能用a[0] - b[0]的方式，会溢出
```java
public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> {
        if (a[1] > b[1]) {
            return 1;
        } else {
            return -1;
        }
    });
    int ans = 1;
    int pos = points[0][1];
    for (int[] point : points) {
        if (point[0] <= pos) {
            continue;
        } else {
            ans++;
            pos = point[1];
        }
    }
    return ans;
}
```