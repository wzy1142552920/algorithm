## LeetCode-522. 最长特殊序列 II

思路：
1、从数据量分析，可以进行枚举

2、如果字符串的子串满足条件，则该字符串也满足条件，转换成求给定的字符串数组中满足条件的最长字符串 -- 关键

3、判断是否为子序列 - 双指针

```java
public int findLUSlength(String[] strs) {
    int len = strs.length;
    int ans = -1;
    for (int i = 0; i < len; i++) {
        boolean flag = true;
        for (int j = 0; j < len; j++) {
            if (i != j && isSubString(strs[i], strs[j])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            ans = Math.max(ans, strs[i].length());
        }
    }
    return ans;
}

private boolean isSubString(String sub, String s) {
    int indexSub = 0;
    int indexS = 0;
    while (indexS < s.length() && indexSub < sub.length()) {
        if (sub.charAt(indexSub) == s.charAt(indexS)) {
            indexSub++;
        }
        indexS++;
    }
    return indexSub == sub.length();
}
```