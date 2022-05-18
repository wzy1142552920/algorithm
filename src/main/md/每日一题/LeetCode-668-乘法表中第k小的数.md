## LeetCode-668-乘法表中第k小的数
二分查找
每行中小于x的数的个数是x / i (i 是行号，1 ~ m)
查找第k个数，也就是找到最小的x，使得小于x的数的个数之和为k个
x最小1，最大 m * n
```java
public int findKthNumber(int m, int n, int k) {
    int l = 1;
    int r = m * n;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (cntSum(mid, m, n) < k) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return l;
}

private int cntSum(int mid, int m, int n) {
    int sum = 0;
    for (int i = 1; i <= m; i++) {
        /*每行小于指定值个数为 Math.min(mid / i, n)*/
        sum += Math.min(mid / i, n);
    }
    return sum;
}
```