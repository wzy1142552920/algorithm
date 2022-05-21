## LeetCode-406-根据身高重建队列

贪心思路：

按照升高降序，升高相同的按前面人数升序。

以该顺序安排第i个，前i-1个人都比i高，剩余的人都比i低，因此只用插入到已有序列的对应位置即可

```java
public int[][] reconstructQueue(int[][] people) {
    int len = people.length;
    List<int[]> list = new ArrayList<>();
    Arrays.sort(people, (a, b) -> {
        if (a[0] != b[0]) {
            return b[0] - a[0];
        } else {
            return a[1] - b[1];
        }
    });
    for (int[] p : people) {
        list.add(p[1], p);
    }
    return list.toArray(new int[len][]);
}
```