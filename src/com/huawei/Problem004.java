package com.huawei;

import java.util.Scanner;

/**
 *
 * 题目描述
 •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 连续输入字符串(输入2次,每个字符串长度小于100)
 * 输出描述:
 输出到长度为8的新字符串数组
 * 示例1
 输入
 abc
 123456789
 输出
 abc00000
 12345678
 90000000
 *
 */

public class Problem004 {
    private static String[] zeros = new String[] {"", "0", "00", "000", "0000", "00000", "000000", "0000000"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            print(str1);
            print(str2);
        }
    }

    private static void print(String str) {
        int n = str.length() / 8;
        int mod = str.length() % 8;

        for (int i = 0; i < n; i++) {
            System.out.println(str.substring(8 * i, 8 * (i + 1)));
        }
        if (mod != 0) {
            System.out.print(str.substring(8 * n, str.length()));
            System.out.println(zeros[8 - mod]);
        }
    }
}
