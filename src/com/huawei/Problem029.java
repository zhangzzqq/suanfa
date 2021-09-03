package com.huawei;

import java.util.Scanner;
/**
 * @Author steven
 * @Description 描述
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2、加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 *
 *
 * 本题含有多组样例输入。
 * 输入描述：
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 *
 * 输出描述：
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 *
 * 输入：
 * abcdefg
 * BCDEFGH
 * 复制
 * 输出：
 * BCDEFGH
 * abcdefg
 *
 *
 * @Date  2021/9/3 10:10
 **/
public class Problem029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(encrypt(s1));
            System.out.println(unEncrypt(s2));
        }
    }

    private static String encrypt(String password) {
        StringBuilder sb = new StringBuilder();
        char[] arr = password.toCharArray();
        for (char ch: arr) {
            if (ch == 'Z')
                sb.append('a');
            else if (ch == 'z')
                sb.append('A');
            else if (ch == '9')
                sb.append('0');
            else if (ch < 'Z' && ch >= 'A') {
                sb.append((char)(ch + 33));
            }
            else if (ch <'z' && ch >= 'a') {
                sb.append((char)(ch - 31));
            }
            else if (ch < '9' && ch >= '0') {
                sb.append((char)(ch + 1));
            }
            else
                sb.append(ch);
        }
        return new String(sb);
    }

    private static String unEncrypt(String password) {
        StringBuilder sb = new StringBuilder();
        char[] arr = password.toCharArray();
        for (char ch : arr) {
            if (ch == 'A')
                sb.append('z');
            else if (ch == 'a')
                sb.append('Z');
            else if (ch == '0')
                sb.append('9');
            else if (ch <= 'Z' && ch > 'A') {
                sb.append((char)(ch + 31));
            }
            else if (ch <= 'z' && ch > 'a') {
                sb.append((char)(ch - 33));
            }
            else if (ch <= '9' && ch > '0') {
                sb.append((char)(ch - 1));
            }
            else
                sb.append(ch);
        }
        return new String(sb);
    }
}
