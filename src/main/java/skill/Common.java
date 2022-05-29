package skill;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/5/29 17:50
 */
public class Common {

    /*
     * 最大公约数
     * */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        return b.compareTo(BigInteger.ZERO) == 0 ? a : gcd(b, a.mod(b));
    }

    /*
     * int数组递减排序
     * */
    public static void sort(int[] arr) {
        int[] array = IntStream.of(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(array));
    }

    /*
     * 计算数组的和
     * */
    public static int sumArray(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    /*
     * 上、下、左、右四个方向遍历
     * */
    public static void dir() {
        HashMap<Character, int[]> hashMap = new HashMap<>();
        hashMap.put('U', new int[]{0, 1});
        hashMap.put('L', new int[]{-1, 0});
        hashMap.put('D', new int[]{0, -1});
        hashMap.put('R', new int[]{1, 0});

        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    }

    /*
     * 常数
     * */
    private static int mod1 = 1000000007; /*1e9 + 7*/
    private static int MAX_INT = 2147483647;

    /*
     * Pair类
     * */
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /*
     * 并查集
     * */
    static class UnionFind {
        int[] parent;
        int[] size;
        int sz;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < parent.length; i++)
                parent[i] = i;
            sz = n;
        }

        int get(int x) {
            return parent[x] == x ? x : get(parent[x]);
        }

        boolean union(int a, int b) {
            int pa = get(a);
            int pb = get(b);
            if (pa == pb)
                return false;
            //we want pa to be new parent
            if (size[pa] < size[pb]) {
                int t = pa;
                pa = pb;
                pb = t;
            }
            size[pa] += size[pb];
            parent[pb] = pa;
            sz--;
            return true;
        }

        int getSize() {
            return sz;
        }
    }

    /*
     * 树状数组
     * */
    static class BIT {
        int[] val;

        BIT(int size) {
            this.val = new int[size + 1];
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += val[idx];
                idx -= idx & -idx;
            }
            return sum;
        }

        int query(int l, int r) {
            return query(r) - query(l - 1);
        }

        void update(int idx, int delta) {
            while (idx < val.length) {
                val[idx] += delta;
                idx += idx & -idx;
            }
        }
    }
}
