package com.huawei;

import java.util.*;
/**
 * @Author steven
 * @Description 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 * @Date  2021/9/3 10:07
 *
 * 输入：
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出：
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 **/
public class Problem026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            boolean[] flag = new boolean[arr.length];

            // 把字符给拿出来排序
            ArrayList<Character> arrayList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (Character.isLetter(arr[i])) {
                    arrayList.add(arr[i]);
                    flag[i] = true;
                }
            }
            Collections.sort(arrayList, new Comparator<Character>() {
                @Override
                public int compare(Character t1, Character t2) {
                    String str1 = String.valueOf(t1);
                    String str2 = String.valueOf(t2);
                    return str1.compareToIgnoreCase(str2);
                }
            });

            // 把排序后的字符放回去
            Iterator<Character> it = arrayList.iterator();
            for (int i = 0; i < arr.length; i++) {
                if (flag[i] && it.hasNext()) {
                    arr[i] = it.next();
                }
            }
            System.out.println(String.valueOf(arr));
        }
    }
}
