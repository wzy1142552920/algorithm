## LeetCode-77-组合

```java
List<List<Integer>> ans = new ArrayList<>();
List<Integer> temp = new ArrayList<>();

public List<List<Integer>> combine(int n, int k) {
    List<Integer> path = new ArrayList<>();
    process1(n, k, 1, path);
    return ans;
}
/*
思路一:
依次考虑当前位置cur,有两种情况： 
1、选择当前位置cur
2、不选择当前位置cur
*/
private void process(int n, int k, int cur, List<Integer> path) {
    if (path.size() + (n - cur + 1) < k) {
        return;
    }
    if (path.size() == k) {
        ans.add(new ArrayList<>(path));
        return;
    }
    path.add(cur);
    process(n, k, cur + 1, path);
    path.remove(path.size() - 1);
    process(n, k, cur + 1, path);
}
/*
思路二：
考虑当前位置，枚举所有可能填的值
*/

private void process1(int n, int k, int cur, List<Integer> path) {
    if (path.size() + (n - cur + 1) < k) {
        return;
    }
    if (path.size() == k) {
        ans.add(new ArrayList<>(path));
        return;
    }
    for (int i = cur; i <= n; i++) {
        path.add(i);
        process1(n, k, i + 1, path);
        path.remove(path.size() - 1);
    }
}

```