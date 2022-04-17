## LeetCode-17-电话号码的字母组合
```java
/*
依次枚举每个位置上字母的所有情况
*/

String table[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
StringBuilder path = new StringBuilder();
List<String> ans = new ArrayList<>();

public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
        return ans;
    }
    char[] digitsChar = digits.toCharArray();
    int len = digits.length();
    process(0, digits);
    return ans;
}

private void process(int pos, String digits) {
    if (pos == digits.length()) {
        ans.add(new StringBuilder(path).toString());
        return;
    }
    if (pos > digits.length()) {
        return;
    }
    for (char c : table[digits.charAt(pos) - '0'].toCharArray()) {
        path.append(c);
        process(pos + 1, digits);
        path.deleteCharAt(path.length() - 1);
    }
}
```