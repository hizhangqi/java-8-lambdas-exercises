package com.systeminfos.job.joinbrix;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowMeBugPassword {

    /**
     * 密码校验： 包含大小写字母+数字  长度>=8 and <=22 所有字符不能出现3次  返回 strong 否则返回 weak
     *
     * @param password
     * @return
     */
    public String solution1(String password) {
        String result = "weak";
        password = password == null ? "" : password.trim();
        int passwordLength = password.length();
        if (passwordLength < 8 || passwordLength > 22) {
            return result;
        }

        Map<String, Long> keyCountMap = Arrays.stream(password.split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        long errorKeyCount = keyCountMap.values().stream().filter(e -> e >= 3).count();
        if (errorKeyCount > 0) {
            return result;
        }

        String lowerCase = password.toLowerCase();
        String upperCase = password.toUpperCase();
        //数字+大小写字母
        String regex = "[a-zA-Z0-9]{8,22}";
        boolean matches = password.matches(regex);
        if (matches && !password.equals(lowerCase) && !password.equals(upperCase)) {
            return "strong";
        }
        return result;
    }

    public static void main(String[] args) {
        ShowMeBugPassword password = new ShowMeBugPassword();
//        System.out.println(password.solution1("abcdefgH1"));
//        System.out.println(password.solution1("abcdefgh123456"));
//        System.out.println(password.solution1("abcdefgh123456"));
//        System.out.println(password.solution1("Abcdefgh1234561234567890"));
        System.out.println(password.solution1("Abcdefgh123456AbA"));
        System.out.println(password.solution1("Abcdefgh123456cbA"));
    }

}