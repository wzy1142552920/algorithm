## LeetCode-135-分发糖果

贪心思路：

左遍历，右遍历，两次遍历，保证分到的数量满足评分的大小关系

```java
public int candy(int[] ratings) {
    int len = ratings.length;
    if (ratings == null || len == 0) {
        return 0;
    }
    if (len == 1) {
        return 1;
    }
    int[] candy = new int[len];
    for (int i = 0; i < len; i++) {
        candy[i] = 1;
    }
    for (int i = 0; i < len - 1; i++) {
        if (ratings[i + 1] > ratings[i]) {
            candy[i + 1] = candy[i] + 1;
        }
    }
    for (int i = len - 1; i > 0; i--) {
        if (ratings[i] < ratings[i - 1]) {
            candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);
        }
    }
    int ans = 0;
    for (int i = 0; i < len; i++) {
        ans += candy[i];
    }
    return ans;
}
```