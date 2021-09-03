package com.huawei;


import java.util.Scanner;
/**
 * @Author steven
 * @Description
 * 描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 处理过程：
 *
 * 起点（0,0）
 *
 * +   A10   =  （-10,0）
 *
 * +   S20   =  (-10,-20)
 *
 * +   W10  =  (-10,-10)
 *
 * +   D30  =  (20,-10)
 *
 * +   x    =  无效
 *
 * +   A1A   =  无效
 *
 * +   B10A11   =  无效
 *
 * +  一个空 不影响
 *
 * +   A10  =  (10,-10)
 *
 * 结果 （10， -10）
 *
 * 注意请处理多组输入输出
 *
 * 输入描述：
 * 一行字符串
 *
 * 输出描述：
 * 最终坐标，以逗号分隔
 *
 * 输入 A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *输出 10,-10
 *
 *
 * @Date
 **/
public class Problem017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int x = 0, y = 0;
            String str = sc.nextLine();
            String[] strs = str.split(";");

            for (String curStr : strs) {
                if (curStr.length() == 0 || curStr.length() > 3) continue;
                char ch = curStr.charAt(0);
                if (!checkNumber(curStr.substring(1, curStr.length()))) continue;
                int value = Integer.parseInt(curStr.substring(1, curStr.length()));

                if (ch == 'A') {
                    x -= value;
                } else if (ch == 'S') {
                    y -= value;
                } else if (ch == 'W') {
                    y += value;
                } else if (ch == 'D') {
                    x += value;
                } else
                    continue;
            }
            System.out.println(x + "," + y);
        }
    }


    private static boolean checkNumber(String str) {
        if (str.length() == 0) return false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')) return false;
        }
        return true;
    }
}
