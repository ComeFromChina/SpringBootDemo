## Java 8中lambda 表达式的实例 ##

```java
// 1. 不需要参数,返回值为 5  
() -> 5  
  
// 2. 接收一个参数(数字类型),返回其2倍的值  
x -> 2 * x  
  
// 3. 接受2个参数(数字),并返回他们的差值  
(x, y) -> x – y  
  
// 4. 接收2个int型整数,返回他们的和  
(int x, int y) -> x + y  
  
// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
(String s) -> System.out.print(s)
```

Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。
在上面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。

## Stream相关用法 ##

在Java中，集合和数组是我们经常会用到的数据结构，需要经常对他们做增、删、改、查、聚合、统计、过滤等操作。相比之下，关系型数据库中也同样有这些操作，但是在Java 8之前，集合和数组的处理并不是很便捷。

不过，这一问题在Java 8中得到了改善，Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。本文就来介绍下如何使用Stream。特别说明一下，关于Stream的性能及原理不是本文的重点，如果大家感兴趣后面会出文章单独介绍。

## Stream介绍 ##

Stream 使用一种类似用SQL语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。

Stream API 可以极大提高Java程序员的生产力，让程序员写出高效、干净、简洁的代码。

这种风格将要处理的元素集合看做一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选、排序、聚合等。

### Stream 有以下特性及优点：

- 无存储。Stream 不是一种数据结构，它指数某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O hannel等。
- 为函数式编程而生。对Stream的任何修改都不会修改背后的数据源，比如对Stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新Stream。
- 惰式执行。Stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
- 可消费性。Stream只能被‘消费’一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。

### Stream 的创建 ###

#### 1、通过已有的集合来创建流

在Java 8中，除了增加了很多Stream相关的类以外，还对集合类自身做了增强，在其中增加了stream方法，可以将一个集合类转换成流。

```java
List<String> strings = Arrays.asList("hello","","world","H","W");
Stream<String> stream = strings.stream();
```

以上，通过一个已有的List创建一个流。除此以外，还有一个parallelStream方法，可以为集合创建一个并行流。

这种通过集合创建出一个Stream的方式也是比较常用的一种方式。

#### 2、通过Stream创建流

可以使用Stream类提供的方法，直接返回一个由指定元素组成的流。

```java
Stream<String> stream = Stream.of("hello","","world","H","W");

```

如以上代码，直接通过of方法，创建并返回一个Stream。

### Stream中间操作 ###

#### **filter**

filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤掉空字符串：

```java
List<String> strings = Arrays.asList("hello","","world","H","W");
strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);
//hello world H W
```

#### **map**

map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：

```java
List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
numbers.stream().map(i -> i*i).forEach(System.out::println);
//9,4,4,9,49,9,25
```

#### **limit/skip**

limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素。以下代码片段使用 limit 方法保留4个元素：

```java
List<Integer> numList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
numList.stream().limit(4).forEach(System.out::println);
//3 2 2 3
System.out.println("---");
numList.stream().skip(4).forEach(System.out::println);
// 7 3 5
```

#### **sorted**

sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法进行排序：

```java
List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
numList.stream().sorted().forEach(System.out::println);
//2 3 4 4 6 7 9

List<String> strings = Arrays.asList("hello","","world","H","W");
strings.stream().sorted().forEach(System.out::println);
//H W hello world 
```

#### **distinct**

distinct主要用来去重，以下代码片段使用 distinct 对元素进行去重：

```java
List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
numList.stream().distinct().forEach(System.out::println);
//6 2 4 3 7 9
```

### Stream最终操作 ###

Stream的中间操作得到的结果还是一个Stream，那么如何把一个Stream转换成我们需要的类型呢？比如计算出流中元素的个数、将流转换成集合等。这就需要最终操作（terminal operation）

最终操作会消耗流，产生一个最终结果。也就是说，在最终操作之后，不能再次使用流，也不能再使用任何中间操作，否则将抛出异常：

`java.lang.IllegalStateException: stream has already been operated upon or closed`

#### **forEach**

Stream 提供了方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：

```java
Random random = new Random();
random.ints().limit(10).forEach(System.out::println);
```

#### **count**

count 用来统计流中元素的个数

```java
List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
System.out.println(numList.stream().count());//7

List<String> strings = Arrays.asList("hello","","world","H","W");
System.out.println(strings.stream().count());//5
```

#### **collect**

collect就是一个归约操作，可以接受各种做法作为参数，将流中的元素累积成一个汇总结果：

```java
List<Integer> numList = Arrays.asList(6, 2, 4, 3, 7, 4, 9);
List<Integer> numCollect = numList.stream().filter(s->s>4).collect(Collectors.toList());
System.out.println(numCollect);//[6, 7, 9]
```

## 总结 ##

本文介绍了Java 8中的Stream 的用途，优点等。还介绍了Stream的几种用法，分别是Stream创建、中间操作和最终操作。

Stream的创建有两种方式，分别是通过集合类的stream方法、通过Stream的of方法。

Stream的中间操作可以用来处理Stream，中间操作的输入和输出都是Stream，中间操作可以是过滤、转换、排序等。

Stream的最终操作可以将Stream转成其他形式，如计算出流中元素的个数、将流转换成集合、以及元素的遍历等。

