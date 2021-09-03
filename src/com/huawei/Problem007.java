package com.huawei;

import java.util.Scanner;
/**
 *
 * 题目描述
 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 输入描述:
 输入一个正浮点数值
 * 输出描述:
 输出该数值的近似整数值
 * 示例1
 输入
 5.5
 输出
 6
 *
 */
public class Problem007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double num = sc.nextDouble();
            int int_part = (int) num;
            double float_part = num - int_part;
            if (float_part >= 0.5)
                System.out.println(int_part + 1);
            else
                System.out.println(int_part);
        }
    }
}
