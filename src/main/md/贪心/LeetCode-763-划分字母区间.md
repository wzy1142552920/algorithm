## LeetCode-763-划分字母区间

贪心思路：
遍历字符串，记录字符串每个字符出现的最后的位置

遍历字符串，更新包含当前字符的字符串最右位置end

如果当前位置i == end，记录答案（end - start + 1），同时更新起点位置start = end + 1

```java
public List<Integer> partitionLabels(String S) {
    int len = S.length();
    int[] pos = new int[26];
    for (int i = 0; i < len; i++) {
        pos[S.charAt(i) - 'a'] = i;
    }
    int start = 0;
    int end = 0;
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < len; i++) {
        end = Math.max(end, pos[S.charAt(i) - 'a']);
        if (i == end) {
            ans.add(end - start + 1);
            start = end + 1;
        }
    }
    return ans;
}
```