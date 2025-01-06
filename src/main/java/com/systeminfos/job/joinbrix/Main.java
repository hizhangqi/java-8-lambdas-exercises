package com.systeminfos.job.joinbrix;

import joptsimple.internal.Strings;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

class Main {

    /**
     * 最小字符串集合
     * Input: new String[] {"ahffaksfajeeubsne", "jefaa"}
     * Output: aksfaje
     * Input: new String[] {"aaffhkksemckelloe", "fhea"}
     * Output: affhkkse
     *
     * @param strArr
     * @return
     */
    public static String MinWindowSubstring(String[] strArr) {
        String strProxy = "";
        String firstStr = strArr[0].trim();
        String secondStr = strArr[1].trim();

        if (secondStr.equals("")) {
            return strProxy;
        }

        Map<String, Long> firstKeyCountMap = Arrays.stream(firstStr.split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        for (int i = 0; i < secondStr.length(); i++) {

        }
        return strProxy;
    }

    public static String NonrepeatingCharacter(String str) {
        AtomicReference<String> strProxy = new AtomicReference<>("");
        str = str.replaceAll(" ", "").trim();
        // code goes here
        Map<String, Long> keyCountMap = Arrays.stream(str.trim().split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        String[] split = str.split("");
        for (String s : split) {
            if (keyCountMap.get(s) == 1 && strProxy.get().equals("")) {
                strProxy.set(s);
                break;
            }
        }
        return strProxy.get();
    }

    public static String ss(String str) {
        str = str.replaceAll(" ", "").trim();
        Map<String, Long> keyCountMap = Arrays.stream(str.split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        String strProxy = "";
        String[] split = str.split("");
        for (String s : split) {
            if (keyCountMap.get(s) == 1 && strProxy.equals("")) {
                strProxy = s;
                break;
            }
        }
        return strProxy;
    }

    public static void intCompare() {
        Integer i1 = 1000;
        Integer i2 = 1000;
        Integer i3 = -128; //-128 --> 127
        Integer i4 = -128; //-128 --> 127

        System.out.println(i1 != i2);
        System.out.println(i1 == i2); //false
        System.out.println(i1.equals(i2));
        System.out.println(i4 == i3); //true
        System.out.println(i4 != i3);
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
//        System.out.println(ss(s.nextLine()));
//        System.out.print(MinWindowSubstring(s.nextLine().split(" ")));
        intCompare();
    }

}