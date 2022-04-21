## LeetCode-93-复原IP地址
```java
List<String> ans = new ArrayList<>();
List<String> path = new ArrayList<>();

public List<String> restoreIpAddresses(String s) {
    process(0, 4, s);
    return ans;
}

private void process(int start, int cnt, String s) {
    if (cnt < 0) {
        return;
    }
//当已经分割成四份，且到了最后一位，收集结果
    if (path.size() == 4 && start == s.length()) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                sb.append(path.get(i));
            } else {
                sb.append(path.get(i)).append('.');
            }
        }
        ans.add(sb.toString());
        return;
    }
    for (int i = start; i < s.length(); i++) {
        String sub = s.substring(start, i + 1);
        if (sub.length() > 3 || sub.startsWith("0") && sub.length() > 1 || Integer.parseInt(sub) > 255) {
            continue;
        } else {
            path.add(sub);
        }
        process(i + 1, cnt - 1, s);
        path.remove(path.size() - 1);
    }
}
```