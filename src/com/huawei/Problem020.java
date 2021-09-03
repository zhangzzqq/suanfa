package com.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author steven
 * @Description
 * 描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有相同长度大于2的子串重复
 *
 * 输入描述：
 * 一组或多组长度超过2的字符串。每组占一行
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 *
 *
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出：
 * OK
 * NG
 * NG
 * OK
 **/
public class Problem020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.length() > 8 && repeatCheck(str) && componentCheck(str))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
    }

    private static boolean repeatCheck(String str) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= str.length() - 3; i++) {
            String substr = str.substring(i, i + 3);
            if (set.contains(substr))
                return false;
            else
                set.add(substr);
        }
        return true;
    }

    private static boolean componentCheck(String str) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean other = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch <= '9' && ch >= '0')
                digit = true;
            else if (ch <= 'Z' && ch >= 'A')
                upperCase = true;
            else if (ch <= 'z' && ch >= 'a')
                lowerCase = true;
            else
                other = true;
        }
        return (upperCase && lowerCase && digit) || (upperCase && lowerCase && other) || (upperCase && digit && other) || (lowerCase && digit && other);
    }
}
