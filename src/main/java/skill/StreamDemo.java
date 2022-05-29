package skill;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：LuckyDog
 * @description：TODO
 * @date ：2022/5/29 16:20
 */
public class StreamDemo {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("abc");
        list.add("abcd");
        list.add("aaabc");

        list.stream()
                .filter(name -> name.startsWith("a"))
                .filter(name -> name.length() == 3)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        String[] name = {"aa, 12", "bb, 23", "cc, 25"};
        Map<String, Integer> map = Stream.of(name)
                .collect(Collectors
                        .toMap(s -> s.split(", ")[0],
                                s -> Integer.parseInt(s.split(", ")[1])));
        System.out.println(map.toString());
    }

}
