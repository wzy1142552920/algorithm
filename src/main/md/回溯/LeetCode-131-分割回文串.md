## LeetCode-131-分割回文串
```java
List<List<String>> ans = new ArrayList<>();
List<String> path = new ArrayList<>();
public List<List<String>> partition(String s) {
    process(0, s);
    return ans;
}

private void process(int start, String s) {
    if (start >= s.length()) {
        ans.add(new ArrayList<>(path));
        return;
    }
/*
依次枚举分割线位置
*/
    for (int i = start; i < s.length(); i++) {
        if (isOK(s.substring(start, i + 1))) {
            path.add(s.substring(start, i + 1));
        } else {
/*
如果不是回文子串，继续找下一个位置
*/
            continue;
        }
        process(i + 1, s);
        path.remove(path.size() - 1);
    }
}

private boolean isOK(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }
    }
    return true;
}
```