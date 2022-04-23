## LeetCode-78-子集

```java
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> subsets(int[] nums) {
    process1(nums, 0);
    return ans;
}

private void process1(int[] nums, int index) {
//添加路径到ans中
    ans.add(new ArrayList<>(path));
    for (int i = index; i < nums.length; i++) {
        path.add(nums[i]);
        process1(nums, i + 1);
        path.remove(path.size() - 1);
    }
}
```