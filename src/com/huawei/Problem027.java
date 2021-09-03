package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/**
 * @Author steven
 * @Description 描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
 * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，按字典序排列后的第k个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 * 输入描述：
 * 先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
 * 输出描述：
 * 输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 *
 * 输入：
 * 3 abc bca cab abc 1
 * 输出：
 * 2
 * bca
 * ----------------
 * 输入：
 * 6 cab ad abcd cba abc bca abc 1
 * 输出：
 * 3
 * bca
 * 复制
 * 说明：
 * abc的兄弟单词有cab cba bca，所以输出3
 * 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
 *
 * @Date  2021/9/3 10:09
 **/
public class Problem027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            String[] arr = new String[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.next();
            }
            String str = sc.next();
            int index = sc.nextInt();

            // 记录字典中哪些是兄弟单词
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                if (check(arr[i], str)) {
                    arrayList.add(arr[i]);
                }
            }
            Collections.sort(arrayList);
            System.out.println(arrayList.size());
            if (index <= arrayList.size())
                System.out.println(arrayList.get(index - 1));
        }
    }

    // 判断s1和s2是否是兄弟单词
    private static boolean check(String s1, String s2) {
        if (s1.equals(s2)) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return String.valueOf(arr1).equals(String.valueOf(arr2));
    }
}
