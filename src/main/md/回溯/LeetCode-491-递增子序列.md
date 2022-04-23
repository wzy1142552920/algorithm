## LeetCode-491-递增子序列
数组中存在相同的数，需要去重，但是不能像子集问题中通过排序，所以需要在每层遍历过程中记录是否遍历过该数
```java
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> findSubsequences(int[] nums) {
    process(nums, 0);
    return ans;
}

private void process1(int[] nums, int index) {
    if (path.size() >= 2) {
        ans.add(new ArrayList<>(path));
    }
    boolean[] used = new boolean[201];
    for (int i = index; i < nums.length; i++) {
        if (path.size() > 0 && path.get(path.size() - 1) > nums[i] || used[nums[i] + 100]) {
            continue;
        }
        used[nums[i] + 100] = true;
        path.add(nums[i]);
        process(nums, i + 1);
        path.remove(path.size() - 1);
    }
}

private void process(int[] nums, int index) {
    if (path.size() >= 2) {
        ans.add(new ArrayList<>(path));
    }
    HashMap<Integer, Boolean> hashMap = new HashMap<>();
    for (int i = index; i < nums.length; i++) {
        if (path.size() > 0 && path.get(path.size() - 1) > nums[i] || hashMap.getOrDefault(nums[i], false)) {
            continue;
        }
        hashMap.put(nums[i], true);
        path.add(nums[i]);
        process(nums, i + 1);
        path.remove(path.size() - 1);
    }
}
```