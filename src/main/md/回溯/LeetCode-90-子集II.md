## LeetCode-90-子集II

集合中存在重复元素
```java
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    process(nums, 0);
    return ans;
}

private void process(int[] nums, int index) {
    ans.add(new ArrayList<>(path));
    for (int i = index; i < nums.length; i++) {
//判断是否和前一个值相等，相等则跳过
        if (i > index && nums[i] == nums[i - 1]) {
            continue;
        }
        path.add(nums[i]);
        process(nums, i + 1);
        path.remove(path.size() - 1);
    }
}
```