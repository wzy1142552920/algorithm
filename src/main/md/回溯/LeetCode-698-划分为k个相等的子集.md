## LeetCode-698-划分为k个相等的子集
思路：

准备k个桶（长度为k的数组），遍历数组中的元素，每个元素选择放到桶中，如果当前桶的累加和小于avg，可以继续添加，否则添加到其他桶中

关键剪枝：

如果遍历之后恢复现场，桶是空的（和初始状态一样），则停止

```java
public boolean canPartitionKSubsets1(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    int[] col = new int[k];
    int len = nums.length;
    if (sum % k != 0) {
        return false;
    }
    int avg = sum / k;
    nums = IntStream.of(nums)          // 变为 IntStream
            .boxed()           // 装盒变为 Stream<Integer>
            .sorted(Comparator.reverseOrder()) // 按自然序相反排序
            .mapToInt(Integer::intValue)       // 变为 IntStream
            .toArray();
    if (nums[0] > avg || nums[0] < avg && (nums[len - 1] + nums[0] > avg)) {
        return false;
    }
    return process1(nums, col, avg, 0);
}

private boolean process1(int[] nums, int[] col, int avg, int index) {
    if (index == nums.length) {
        return true;
    }
    for (int i = 0; i < col.length; i++) {
        if (col[i] + nums[index] <= avg) {
            col[i] += nums[index];
            if (process1(nums, col, avg, index + 1)) {
                return true;
            }
            col[i] -= nums[index];
// 剪枝
            if(col[i] == 0) {
                break;
            }
        } else {
            continue;
        }
    }
    return false;
}
```