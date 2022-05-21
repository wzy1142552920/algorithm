## LeetCode-738-单调递增的数字

贪心思路：

如果第i个数大于第i+1个数，将第i+1个数变成9，第i个数减1

从后往前遍历，遍历到最前面的满足第i个数大于第i+1个数的位置

将该位置之后的数全改成9即可

```java
public int monotoneIncreasingDigits(int n) {
    String sting = String.valueOf(n);
    char[] chars = sting.toCharArray();
    int len = sting.length();
    int index = len - 1;
    for (int i = len - 1; i > 0; i--) {
        if (chars[i - 1] > chars[i]) {
            chars[i - 1]--;
            index = i - 1;
        }
    }
    for (int i = index + 1; i < len; i++) {
        chars[i] = '9';
    }
    return Integer.parseInt(String.valueOf(chars));
}
```