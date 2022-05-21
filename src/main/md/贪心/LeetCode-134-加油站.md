## LeetCode-134-加油站
贪心思路一：

遍历所有位置，如果从当前位置开始的累加和小于零，则该位置以前（包括该位置）上的数都不满足；

```java
public int canCompleteCircuit(int[] gas, int[] cost) {
    int len = gas.length;
    int[] diff = new int[len];
    for (int i = 0; i < len; i++) {
        diff[i] = gas[i] - cost[i];
    }
    int preSum = 0;
    for (int i = 0; i < len;) {
        preSum = 0;
        for (int j = 0; j < len; j++) {
            preSum += diff[(i + j) % len];
            if (preSum < 0) {
                i += j + 1;
                break;
            }
        }
        if (preSum >= 0) {
            return i;
        }
    }
    return -1;
}
```

贪心思路二：

题目已知答案是唯一的，找到累加最小值后面的位置即为起始点

```java
public int canCompleteCircuit(int[] gas, int[] cost) {
    int len = gas.length;
    int min = Integer.MAX_VALUE;
    int index = 0;
    int sum = 0;
    for (int i = 0; i < len; i++) {
        int diff = gas[i] - cost[i];
        sum += diff;
        if (sum < min) {
            min = sum;
            index = i;
        }
    }
    return sum < 0 ? -1 : (index + 1) % len;
}
```

