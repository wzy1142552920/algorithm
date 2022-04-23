## LeetCode-47-全排列 II
存在重复数，排序，如果当前数和前一个数相等并且使用过，则跳过
```java
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    process(nums, visited, 0);
    return ans;
}

private void process(int[] nums, boolean[] visited, int pos) {
    if (pos == nums.length) {
        ans.add(new ArrayList<>(path));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (visited[i]) {
            continue;
        }
        if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
            continue;
        }
        path.add(nums[i]);
        visited[i] = true;
        process(nums, visited, pos + 1);
        visited[i] = false;
        path.remove(path.size() - 1);
    }
}
```