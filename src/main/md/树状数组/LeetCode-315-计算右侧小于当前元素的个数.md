## LeetCode-315-计算右侧小于当前元素的个数

1、用桶来记录每个值得个数，小于当前值得个数即为从startIndex到当前位置所有桶的计数和

将原问题转换成计算前n个累加和 - 用树状数组来解答

2、数组中的数的范围可能很大，如果直接用当前数的大小作为index，需要的数组长度会很大，比如{0，99999}

进行离散化处理

3、题目要计算的是右边所有小于当前位置的数的个数，所以计算时需要从后往前遍历，这样前半段小的数不会影响结果

最后再将得到的结果翻转（翻转的效率比直接的头插效率高）

```java
class Solution {
    int[] tree;
    int[] arr;

    public List<Integer> countSmaller(int[] nums) {
        int[] discretNums = discret(nums);
        Arrays.sort(discretNums);
        // 离散化
        init(discretNums);
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            int idx = findIdx(discretNums, nums[i]);
            ans.add(sum(idx - 1));
            //ans.add(0, sum(idx - 1)); 头插的效率会更底
            add(idx, 1);
        }
        //翻转
        Collections.reverse(ans);
        return ans;
    }

    private void init(int[] nums) {
        tree = new int[nums.length + 1];
        arr = nums;
    }

    private int findIdx(int[] discretNums, int num) {
        return Arrays.binarySearch(discretNums, num) + 1;
    }

    private int[] discret(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int n : nums) {
            hashSet.add(n);
        }
        int[] res = new int[hashSet.size()];
        int index = 0;
        for (int s : hashSet) {
            res[index++] = s;
        }
        return res;
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

    public int lowBit(int x) {
        return x & (-x);
    }
}
```