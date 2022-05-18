## LeetCode-122-买卖股票的最佳时机II
贪心思路：
累加所有上升端的高度即为最大收益
```java
public int maxProfit(int[] prices) {
    int len = prices.length;
    int ans = 0;
    for (int i = 1; i < len; i++) {
        ans += prices[i] - prices[i - 1] > 0 ? (prices[i] - prices[i - 1]) : 0;
    }
    return ans;
}
```