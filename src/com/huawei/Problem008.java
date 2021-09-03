package com.huawei;

import java.util.*;
/**
 描述
 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

 输入描述：
 先输入键值对的个数
 然后输入成对的index和value值，以空格隔开

 输出描述：
 输出合并后的键值对（多行）
 输入：
 4
 0 1
 0 2
 1 2
 3 4
 输出：
 0 3
 1 2
 3 4
 *
 */

public class Problem008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            SortedMap<Integer, Integer> map = new TreeMap<>();
            while (num-- != 0) {
                int index = sc.nextInt();
                int value = sc.nextInt();

                if (map.containsKey(index)) {
                    int oldValue = map.get(index);
                    map.put(index, oldValue + value);
                }
                else {
                    map.put(index, value);
                }
            }

            Set<Integer> resultSet = map.keySet();
            for (Integer key : resultSet) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
