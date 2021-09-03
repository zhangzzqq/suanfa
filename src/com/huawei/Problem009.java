package com.huawei;


import java.util.Scanner;
/**
 *
 * 题目描述
 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 输入描述:
 输入一个int型整数

 * 输出描述:
 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 示例1
 输入
 9876673
 输出
 37689
 *
 */
public class Problem009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();

            boolean[] flags = new boolean[10];
            StringBuilder sb = new StringBuilder();
            while (num != 0) {
                int mod = num % 10;
                num = num / 10;
                if (!flags[mod]) {
                    sb.append(String.valueOf(mod));
                    flags[mod] = true;
                }
            }
            System.out.println(Integer.parseInt(new String(sb)));
        }
    }
}
