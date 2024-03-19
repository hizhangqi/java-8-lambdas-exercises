package com.systeminfos.job.joinbrix;

import java.util.HashMap;

public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();

        for (int i = 0; i < T.length(); i++) {
            hasFound.put(T.charAt(i), 0);
            if (needToFind.containsKey(T.charAt(i))) {
                needToFind.put(T.charAt(i), needToFind.get(T.charAt(i)) + 1);
            } else {
                needToFind.put(T.charAt(i), 1);
            }
        }
        int begin = 0;
        int minWindowSize = S.length();
        String retString = "";

        int count = 0;

        for (int end = 0; end < S.length(); end++) {
            Character end_c = S.charAt(end);
            if (needToFind.containsKey(end_c)) {
                hasFound.put(end_c, hasFound.get(end_c) + 1);
                if (hasFound.get(end_c) <= needToFind.get(end_c)) {
                    count++;
                }
                if (count == T.length()) {
                    while ((!needToFind.containsKey(S.charAt(begin))) || (hasFound.get(S.charAt(begin)) > needToFind.get(S.charAt(begin)))) {
                        if (needToFind.containsKey(S.charAt(begin))) {
                            hasFound.put(S.charAt(begin), hasFound.get(S.charAt(begin)) - 1);
                        }
                        begin++;
                    }
                    if ((end - begin + 1) <= minWindowSize) {
                        minWindowSize = end - begin + 1;
                        retString = S.substring(begin, end + 1);
                    }
                }
            }
        }
        return retString;
    }

    public String minWindow2(String targetStr, String sourceStr) {
        targetStr = targetStr.replaceAll(" ", "").trim();
        sourceStr = sourceStr.replaceAll(" ", "").trim();

        String targetMinWindowStr = "";
        if (targetStr.equals("")) {
            return targetMinWindowStr;
        }

        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();

        for (int i = 0; i < sourceStr.length(); i++) {
            Character chi = sourceStr.charAt(i);
            hasFound.put(chi, 0);
            needToFind.put(chi, needToFind.containsKey(chi) ? needToFind.get(chi) + 1 : 1);
        }

        int begin = 0;
        int targetMinWindowSize = targetStr.length();

        int count = 0;

        for (int end = 0; end < targetStr.length(); end++) {
            Character end_c = targetStr.charAt(end);
            if (needToFind.containsKey(end_c)) {
                hasFound.put(end_c, hasFound.get(end_c) + 1);
                if (hasFound.get(end_c) <= needToFind.get(end_c)) {
                    count++;
                }
                if (count == sourceStr.length()) {
                    while ((!needToFind.containsKey(targetStr.charAt(begin))) || (hasFound.get(targetStr.charAt(begin)) > needToFind.get(targetStr.charAt(begin)))) {
                        if (needToFind.containsKey(targetStr.charAt(begin))) {
                            hasFound.put(targetStr.charAt(begin), hasFound.get(targetStr.charAt(begin)) - 1);
                        }
                        begin++;
                    }
                    if ((end - begin + 1) <= targetMinWindowSize) {
                        targetMinWindowSize = end - begin + 1;
                        targetMinWindowStr = targetStr.substring(begin, end + 1);
                    }
                }
            }
        }
        return targetMinWindowStr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
