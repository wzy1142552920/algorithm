## LeetCode-22-括号生成

回溯，初始左右括号数，没增加对应的括号数减一：

当剩余的左括号数大于右括号数时，直接返回；

当剩余的左括号数小于右括号数时，可以选择右括号；

当剩余的左括号数大于零时，可以选择左括号；
```java
List<String> ans = new ArrayList<>();
StringBuilder path = new StringBuilder();

public List<String> generateParenthesis(int n) {
    path.append('(');
    process(n - 1, n);
    return ans;
}

private void process(int left, int right) {
    if (left == 0 && right == 0) {
        ans.add(new StringBuilder(path).toString());
        return;
    }
    if (left > right) {
        return;
    }
    if (left > 0) {
        path.append('(');
        process(left - 1, right);
        path.deleteCharAt(path.length() - 1);
    }
    if (left < right) {
        path.append(')');
        process(left, right - 1);
        path.deleteCharAt(path.length() - 1);
    }
}
```