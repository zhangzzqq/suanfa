package com.huawei;

import java.util.Scanner;
/**
 *
 * 题目描述
 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 输入描述:
 输入一个整数（int类型）
 * 输出描述:
 这个数转换成2进制后，输出1的个数
 * 示例1
 输入
 5
 输出
 2
 *
 */
public class Problem015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int count = 0;
            while (num != 0) {
                if ((num & 1) != 0) {
                    count++;
                }
                num = num >>> 1;
            }
            System.out.println(count);
        }
    }
}
