package com.huawei;

import java.util.Scanner;
/**
 * 题目描述
 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，
 然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 输入描述:
 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 * 输出描述:
 输出输入字符串中含有该字符的个数。
 * 示例1
 输入
 ABCDEF A
 输出
 1
 *
 */
public class Problem002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine().toUpperCase();
            String res = sc.nextLine().toUpperCase();

            char[] chars = str.toCharArray();
            char ch = res.toCharArray()[0];
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ch) count++;
            }
            System.out.println(count);
        }
    }
}
