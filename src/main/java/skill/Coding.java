package skill;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/5/29 22:31
 */
public class Coding {


    /*
    * 字符串切割
    * */
    @Test
    public void test1() {
        String s = ".a.b.c.";
        String[] split = s.split("\\.");
        //[, a, b, c] 最后一个.不会切割
        System.out.println(Arrays.toString(split));
    }


}
