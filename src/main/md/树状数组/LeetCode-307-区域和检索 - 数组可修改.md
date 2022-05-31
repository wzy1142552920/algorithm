## LeetCode-307-区域和检索 - 数组可修改
树状数组解决的问题：
1、单点更新
2、区间和

关键方法：
1、lowBit：求一个数二进制只保留最低位为1，eg：1100 -> 0100

```java
class NumArray {
    int[] nums;
    int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void add(int index, int val) {
        while (index < tree.length) {
            tree[index] += val;
            index += lowBit(index);
        }
    }

    public int sum(int index) {
        int res = 0;
        while (index > 0) {
            res += tree[index];
            index -= lowBit(index);
        }
        return res;
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }

    public int lowBit(int x) {
        return x & (-x);
    }
}
```