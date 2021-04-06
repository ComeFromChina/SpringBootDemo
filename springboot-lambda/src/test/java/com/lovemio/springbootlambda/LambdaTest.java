package com.lovemio.springbootlambda;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author liwenjin
 * @date 2021年04月06日 14:37
 */
@SpringBootTest
public class LambdaTest {

    /*===================Stream中间操作===================*/
    @Test
    public void testFilter() {
        //filter方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤掉空字符串：
        List<String> strings = Arrays.asList("hello","","world","H","W");
        strings.stream().filter(s-> !s.isEmpty()).forEach(System.out::println );
    }

    @Test
    public void testMap() {
        //map方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> numbers = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
        numbers.stream().map(n->n*n).forEach(System.out::println);
    }

    @Test
    public void testLimitAndSkip() {

        //limit/skip limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素。
        List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
        numList.stream().limit(4).forEach(System.out::println);
        System.out.println("---");
        numList.stream().skip(4).forEach(System.out::println);

    }

    @Test
    public void testSorted() {
        //sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法进行排序：
        List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
        numList.stream().sorted().forEach(System.out::println);

        List<String> strings = Arrays.asList("hello","","world","H","W");
        strings.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        //distinct主要用来去重，以下代码片段使用 distinct 对元素进行去重：
        List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
        numList.stream().distinct().forEach(System.out::println);
        //6 2 4 3 7 9
    }

    /*===================Stream最终操作===================*/
    @Test
    public void testForEach(){
        //Stream 提供了方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void testCount(){
        //count 用来统计流中元素的个数
        List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
        System.out.println(numList.stream().count());

        List<String> strings = Arrays.asList("hello","","world","H","W");
        System.out.println(strings.stream().count());
    }

    @Test
    public void testCollect(){
        //collect就是一个归约操作，可以接受各种做法作为参数，将流中的元素累积成一个汇总结果：
        List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
        List<Integer> numCollect = numList.stream().filter(s->s>4).collect(Collectors.toList());
        System.out.println(numCollect);//[6, 7, 9]

    }
}