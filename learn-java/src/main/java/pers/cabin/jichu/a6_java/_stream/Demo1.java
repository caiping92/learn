package pers.cabin.jichu.a6_java._stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * 可以从不同的数据源创建stream。
 * java collection包中的Collections，Lists，Sets这些类中新增stream()和parallelStream()方法
 * 通过这些方法可以创建一个顺序stream（sequential streams）或者一个并发的stream(Parallel streams)。
 * 并发stream(Parallel streams)更适合在多线程中使用，
 * 顺序流（sequential streams）并发stream(Parallel streams)，
 *
 *
 * http://www.jianshu.com/p/0c07597d8311
 *
 * Created by caiping on 2017/9/21.
 */
public class Demo1 {


    public static void main(String[] args) {

//        test1();
//        test2();


        test6();

    }

    /*
    *

   stream包含中间（intermediate operations）和最终（terminal operation）两种形式的操作。
   中间操作（intermediate operations）的返回值还是一个stream，因此可以通过链式调用将中间操作（intermediate operations）串联起来。
   最终操作（terminal operation）只能返回void或者一个非stream的结果。
  filter, map ，sorted是中间操作，
  而forEach是一个最终操作。

  上面例子中的链式调用也被称为操作管道流。

    *
    * */
    public static void test1() {

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
// C1
// C2

    }


    public static void test2() {

        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
    }


    /**
     * JAVA 8中的IntStream,LongStream,DoubleStream这些流能够处理基本数据类型如：int,long,double。
     * 比如：IntStream可以使用range()方法能够替换掉传统的for循环
     */
    public static void test3() {

        IntStream.range(1, 4)
                .forEach(System.out::println);

    }

    public static void test4() {

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);  // 5.0

    }

    public static void test5() {

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                });

    }

    public static void test6() {

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {//最终操作
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

// map:      d2
// anyMatch: D2
// map:      a2
// anyMatch: A2

    }
}
