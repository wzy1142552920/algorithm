## LeetCode-427-建立四叉树

1、二维数组，左上（0，0），右下（n， n）

2、二维数组中递归，避免使用中间值（dx、dy）, 回溯需要恢复现场，中间值容易出问题

```java
public Node construct(int[][] grid) {
    int len = grid.length;
    return process(grid, 0, 0, len, len);
}

private Node process(int[][] grid, int sX, int sY, int eX, int eY) {
//            int dx = eX - sX;
//            int dy = eY - sY;
    if ((eX - sX) == 1 && (eY - sY) == 1) {
        return new Node(grid[sX][sY] == 1, true);
    }

    Node upLeft = process(grid, sX, sY, sX + (eX - sX) / 2, sY + (eY - sY) / 2);
    Node upRight = process(grid, sX, sY + (eY - sY) / 2, sX + (eX - sX) / 2, eY);
    Node downLeft = process(grid, sX + (eX - sX) / 2, sY, eX, sY + (eY - sY) / 2);
    Node downRight = process(grid, sX + (eX - sX) / 2, sY + (eY - sY) / 2, eX, eY);

    if (upLeft.isLeaf && upRight.isLeaf && downLeft.isLeaf && downRight.isLeaf) {
        if (upLeft.val && upRight.val && downLeft.val && downRight.val ||
                !upLeft.val && !upRight.val && !downLeft.val && !downRight.val) {
            return new Node(upLeft.val, true);
        }
    }
    return new Node(true, false, upLeft, upRight, downLeft, downRight);
}
```