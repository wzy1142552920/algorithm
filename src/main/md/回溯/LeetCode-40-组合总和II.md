## LeetCode-40-组合总和II
```java
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    process(target, candidates, 0);
    return ans;
}

private void process(int target, int[] candidates, int idx) {
    if (target == 0) {
        ans.add(new ArrayList<>(path));
        return;
    }
    for (int i = idx; i < candidates.length; i++) {
        if (target - candidates[i] < 0) {
            break;
        }
//当前位置值和前一个位置的值相等时，continue，去重
        if (i > idx && candidates[i] == candidates[i - 1]) {
            continue;
        }
        path.add(candidates[i]);
        process(target - candidates[i], candidates, i + 1);
        path.remove(path.size() - 1);
    }
}
```