package com.huawei;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
/**
 * @Author steven
 * @Description 描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 输入：
 * abcdd
 * aabcddd
 *
 * 输出：
 * dd
 * aaddd
 *
 * @Date  2021/9/3 10:05
 *
 *
 **/

public class Problem023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = str.toCharArray();

            for (char ch : chars) {
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            int min = 30;
            for (char ch : map.keySet()) {
                if (map.get(ch) < min) min = map.get(ch);
            }
//            Iterator<Character> it = map.keySet().iterator();
//            while (it.hasNext()) {
//                char ch = it.next();
//                if (map.get(ch) == min)
//                    it.remove();
//            }

            StringBuilder sb = new StringBuilder();
            for (char ch : chars) {
                if (map.get(ch) != min)
                    sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}
