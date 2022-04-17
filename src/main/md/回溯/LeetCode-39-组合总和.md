## LeetCode-39-组合总和
```java
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    process(target, candidates, 0);
    return ans;
}

private void process(int target, int[] candidates, int idx) {
    if (target == 0) {
        ans.add(new ArrayList<>(path));
        return;
    }
    if (target < 0) {
        return;
    }
// 同一个集合，避免重复取，每次从idx开始
    for (int i = idx; i < candidates.length; i++) {
        path.add(candidates[i]);
// 可以重复，所以是i而不是i + 1
        process(target - candidates[i], candidates, i);
        path.remove(path.size() - 1);
    }
}
```