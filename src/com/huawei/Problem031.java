package com.huawei;

import java.util.Scanner;
/**
 * @Author steven
 * @Description 描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 本题含有多组样例输入。
 *
 * 输入描述：
 * 输入一个字符串
 *
 * 输出描述：
 * 返回有效密码串的最大长度
 *
 * 输入：
 * ABBA
 * 输出：
 * 4
 * @Date  2021/9/3 10:12
 **/
public class Problem031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] arr = str.split("[^a-zA-Z]+"); // limit参数为0，不包括最后一个可能的空字符串
            for (int i = arr.length - 1; i > 1; i--) {
                System.out.print(arr[i] + " ");
            }
            //如果字符串数组的第一个元素是空串，那么下标为1的元素就是最后一个要输出的元素，末尾不要再加空格
            if (arr[0].length() == 0)
                System.out.println(arr[1]);
            else {
                System.out.println(arr[1] + " " + arr[0]);
            }
        }
    }
}
