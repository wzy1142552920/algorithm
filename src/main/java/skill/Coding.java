package skill;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/5/29 22:31
 */
public class Coding {

    /**
    * 字符串切割
    * */
    @Test
    public void test1() {
        String s = ".a.b.c.";
        String[] split = s.split("\\.");
        //[, a, b, c] 最后一个.不会切割
        System.out.println(Arrays.toString(split));
    }

    /**
     * 两数相除，向上取整
    * */
    @Test
    public void test2() {
        int a = 2;
        int k = 2;
        int res = (a + k - 1) / k;
    }

    /**
    * 二分计算中点，使用位运算(运算符优先级)
    * */
    @Test
    public void test3() {
        int l = 0;
        int r = 10;
        int mid = l + ((r - l) >> 1);
    }
}
