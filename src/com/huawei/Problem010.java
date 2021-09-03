package com.huawei;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 * 输入描述:
 输入N个字符，字符在ACSII码范围内。
 * 输出描述:
 输出范围在(0~127)字符的个数。
 * 示例1
 输入
 abc
 输出
 3
 *
 */
public class Problem010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            Set<Character> set = new HashSet<>();
            String str = sc.nextLine();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            System.out.println(set.size());
        }
    }
}
