package com.systeminfos.interview.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetTest {
    public static void main(String[] args) {
        list2Array();
    }

    private static void list2Array() {
        String[] s = new String[]{"dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"};
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        //没有指定类型的话会报错
        s = list.toArray(new String[0]);
        System.out.println(s[0]);
    }

    private static List<Integer> array2List() {
        //最简便的方法
        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        //使用 Java8 的 Stream(推荐)
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int[] myArray2 = {1, 2, 3};
        myList = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        return myList;
    }

    private static List<String> array2ListByGuava() {

        String[] aStringArray = new String[]{"string", "elements"};
        List<String> il = ImmutableList.of("string", "elements");  // from varargs
        il = ImmutableList.copyOf(aStringArray);      // from array

        List<String> anotherListOrCollection = new ArrayList<>();
        List<String> l1 = Lists.newArrayList(anotherListOrCollection);    // from collection
        List<String> l2 = Lists.newArrayList(aStringArray);               // from array
        List<String> l3 = Lists.newArrayList("or", "string", "elements"); // from varargs
        return il;
    }


    // Set 去重代码示例
    public static <T> java.util.Set<T> removeDuplicateBySet(List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return new HashSet<>();
        }
        return new java.util.HashSet<>(data); //O(1)
    }

    // List 去重代码示例
    public static <T> List<T> removeDuplicateByList(List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return new ArrayList<>();
        }
        List<T> result = new ArrayList<>(data.size());
        for (T current : data) {
            if (!result.contains(current)) { //O(n)
                result.add(current);
            }
        }
        return result;
    }


    /**
     * 2 的 1 到 30 次方的和 彩礼数
     */
    @Test
    public void test2MonthSquareSum() {
        long sumOfPowers = 0;
        for (int i = 1; i <= 30; i++) {
            sumOfPowers += Math.pow(2, i);
        }
        System.out.println("2 的 1 到 30 次方的和是: " + sumOfPowers);
        System.out.println("2 的 1 到 30 次方的和是: " + sumOfPowers / 1000 + " 元");
        System.out.println("2 的 1 到 30 次方的和是: " + sumOfPowers / (1000 * 1000) + " 万元");


        int sum = IntStream.rangeClosed(1, 30).map(i -> 1 << i).sum();
        System.out.println("Sum of 2^1 to 2^30 is: " + sum);

        int i = 4;
        System.out.println(i << 1);
        System.out.println(i >> 1);

        long sumOfPowers2 = IntStream.rangeClosed(1, 30).mapToLong(j -> (long) Math.pow(2, j)).sum();
        System.out.println("2 的 1 到 30 次方的和是: " + sumOfPowers2);
    }

    @Test
    public void testGetMinMaxValue() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 4, 10);
        // 求最大值
        int max = numbers.stream().max(Integer::compare).get();
        // 求最小值
        int min = numbers.stream().min(Integer::compare).get();
        long otherNums = numbers.stream().filter(e -> e != max && e != min).count();
        System.out.println("min:" + min + " max:" + max + " otherNums:" + otherNums);
    }

    @Test
    public void testGetGroupDate() {
        String accessLogs = "2024-01-01 01:01:01 /actionUrl\n" + "2024-01-01 01:02:01 /actionUrl\n" + "2024-01-01 01:03:01 /actionUrl\n" + "2024-01-01 01:04:01 /actionUrl";
        String regex = "\n";
        String[] split = accessLogs.split(regex);

        Map<String, String> dateMap = new HashMap<>();

        Arrays.stream(split).forEach(e -> {
            String[] dateSplit = e.split("\\s");
            System.out.println(dateSplit);
            String key =
            dateMap.put(dateSplit[0] + dateSplit[1], dateSplit[2]);
        });
    }


}
