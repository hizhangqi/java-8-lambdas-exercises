package com.systeminfos.job.joinbrix;

import joptsimple.internal.Strings;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

class Main {

    public static String MinWindowSubstring(String[] strArr) {
        // code goes here
        return strArr[0];
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

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
//    System.out.print(MinWindowSubstring(s.nextLine().split(" ")));
        System.out.println(ss(s.nextLine()));
    }

}