package com.huawei;

import java.util.Scanner;
/**
 * @Author steven
 * @Description 描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 *
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 * 请注意处理多组输入输出！
 *
 * 备注：
 * 1<=N<=3000
 * 输入描述：
 * 有多组用例，每组都包含两行数据，第一行是同学的总数N，第二行是N位同学的身高，以空格隔开
 *
 * 输出描述：
 * 最少需要几位同学出列
 * @Date  2021/9/3 10:06
 *
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出：
 * 4
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 **/
public class Problem024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }

            int[] dp1 = new int[num];
            int[] dp2 = new int[num];
            // 从左向右
            for (int i = 0; i < num; i++) {
                dp1[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i] && dp1[i] < dp1[j] + 1)
                        dp1[i] = dp1[j] + 1;
                }
            }
            //从右向左
            for (int i = num - 1; i >= 0; i--) {
                dp2[i] = 1;
                for (int j = num - 1; j > i ; j--) {
                    if (arr[j] < arr[i] && dp2[i] < dp2[j] + 1)
                        dp2[i] = dp2[j] + 1;
                }
            }

            int max = 0;
            for (int i = 0; i < num; i++) {
                if (max < dp1[i] + dp2[i])
                    max = dp1[i] + dp2[i];
            }
            System.out.println(num - max + 1);
        }
    }
}
