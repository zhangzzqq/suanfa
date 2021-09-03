package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @Author steven
 * @Description 描述
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 *
 * 输入:
 *
 * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
 *
 * 输出:
 *
 * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 *
 * 输入描述：
 * 输入说明
 * 1 输入一个正偶数n
 * 2 输入n个整数
 * 注意：数据可能有多组
 *
 * 输出描述：
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * 输入：
 * 4
 * 2 5 6 13
 * 2
 * 3 6
 * 输出：
 * 2
 * 0
 *
 *
 * @Date  2021/9/3 10:10
 **/
//https://blog.csdn.net/cillyb/article/details/55511666
public class Problem028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            ArrayList<Integer> A = new ArrayList<>(); // 存放奇数
            ArrayList<Integer> B = new ArrayList<>(); // 存放偶数
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x % 2 == 0) {
                    B.add(x);
                } else
                    A.add(x);
            }

            boolean[] visited = new boolean[B.size()];
            int[] match = new int[B.size()];
            int sum = 0;
            for (Integer anA : A) {
                Arrays.fill(visited, false);
                if (find(anA, B, visited, match))
                    sum++;
            }
            System.out.println(sum);
        }
    }

    private static boolean find(Integer x, ArrayList<Integer> B, boolean[] visited, int[] match) {
        for (int j = 0; j < B.size(); j++) {
            if (isPrime(x + B.get(j)) && !visited[j]) {
                visited[j] = true;
                if (match[j] == 0 || find(match[j], B, visited, match)) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(Integer x) {
        for (int i = 2; i <= Math.pow(x, 0.5); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
