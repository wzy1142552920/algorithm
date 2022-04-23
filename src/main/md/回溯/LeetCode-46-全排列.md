## LeetCode-46-全排列
枚举每个位置上可以取得数，用used数据记录是否使用过
```java
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> permute(int[] nums) {
    boolean[] used = new boolean[nums.length];
    process(nums, used, 0);
    return ans;
}

private void process(int[] nums, boolean[] used, int pos) {
    if (pos == nums.length) {
        ans.add(new ArrayList<>(path));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) {
            continue;
        }
        used[i] = true;
        path.add(nums[i]);
        process(nums, used, pos + 1);
        path.remove(path.size() - 1);
        used[i] = false;
    }
}
```