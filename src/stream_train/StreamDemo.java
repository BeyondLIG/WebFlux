package stream_train;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: licg
 * @Date: 2019/7/11
 * @Description：
 */
public class StreamDemo {
    public static int doubleNum(int i){
        System.out.println("double number");
        return i * 2;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(IntStream.of(nums).sum());

        System.out.println(IntStream.of(nums).map(x -> x * 2).sum());
        System.out.println(IntStream.of(nums).map(StreamDemo::doubleNum).sum());
        System.out.println(IntStream.of(nums).map(StreamDemo::doubleNum));

        // 集合Collection
        List<String> list = new ArrayList<>();
        list.stream();
        list.parallelStream();

        // 数组Arrays
        Arrays.stream(new int[]{1, 2, 3});
        IntStream.of(1, 2, 3);
        IntStream.rangeClosed(1, 10);

        // random创建无限流
        new Random().ints().limit(10);


        String str = "my name is china";

        str.chars().parallel().forEach(i -> System.out.print((char)i));
        str.chars().parallel().forEachOrdered(i -> System.out.print((char)i));

        // collect to list
        List<String> list1 = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list1);

        Optional<String> letter =  Stream.of(str.split(" ")).reduce((x, y) -> x + "|" + y);
        System.out.println(letter.orElse(""));

        String letter1 = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" +s2);
        System.out.println(letter1);

        Integer length = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);

        Optional<String> max = Stream.of(str.split(" ")).max(Comparator.comparingInt(String::length));
        System.out.println(max.get());

        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());

    }
}