package com.huawei;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @Author steven
 * @Description 描述
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 *
 * 将输入的两个字符串合并。
 *
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 *
 *
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 *
 * 注意本题含有多组样例输入
 *
 * 输入描述：
 * 本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。
 *
 * 输出描述：
 * 输出转化后的结果。每组样例输出一行。
 *
 * 输入：
 * dec fab
 * 输出：
 * 5D37BF
 *
 *
 * @Date  2021/9/3 10:11
 **/
public class Problem030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            String str = s1 + s2;
            char[] arr = str.toCharArray();
            char[] arr1 = new char[(arr.length + 1) / 2];
            char[] arr2 = new char[(arr.length + 1) / 2];
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    arr1[i / 2] = arr[i];
                }
                else {
                    arr2[i / 2] = arr[i];
                }
            }
            if (arr.length % 2 == 0) {
                Arrays.sort(arr2);
            }
            else {
                Arrays.sort(arr2, 0, arr2.length - 1);
            }
            Arrays.sort(arr1);
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    arr[i] = arr1[i / 2];
                }
                else {
                    arr[i] = arr2[i / 2];
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char aChar : arr) {
                sb.append(convert(aChar));
            }
            System.out.println(sb);
        }
    }

    private static String convert(char ch) {
        String helper1 = "0123456789ABCDEFabcdef";
        String helper2 = "084C2A6E195D3B7F5D3B7F";
        if ((ch <= '9' && ch >= '0') || (ch <= 'F' && ch >= 'A') || (ch <= 'f' && ch >= 'a')) {
            int index = helper1.indexOf(ch);
            return String.valueOf(helper2.charAt(index));
        }
        return String.valueOf(ch);
    }
}
