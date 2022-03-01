/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Admin
 */
public class TestAndroid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /* Bai 1
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        int sum = tinhTongBinhPhuong(arr, 2, 3);
        System.out.println("sum = " + sum);
         */
        
        /* Bai 2
        String cv = convert(1234566666, 2);
        System.out.println("cvv = " + cv);
         */
        
        /*
        Bai 3
        String check = "ABCCBA";
        Boolean checkSym = checkSymetryString(check);
        if (checkSym) {
            System.out.println("Day la chuoi doi xung");
        } else {
            System.out.println("Day khong phai la chuoi doi xung");
        }
        */
        
        /* Bai 4
        String test = "AABBCCC";
        System.out.println("Chuoi ban dau = " + test);
        String test2 = checkSymetryStringVer2(test);
        System.out.println(test2);
         */
    }

    public static int tinhTongBinhPhuong(int arrInput[][], int m, int n) {
        //m va m la kich thuoc mang
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arrInput[i][j] % 2 == 0) {
                    sum += Math.pow(arrInput[i][j], 2);
                }
            }
        }
        return sum;
    }

    public static String convert(int value, int toStrLen) {
        //lay gia tri lon nhat voi so chu cai la "toStrLen"
        int maxWithToStrLen = (int) Math.pow(10, toStrLen);
        //rut gon Value xuong "toStrLen" chu cai
        while (value > maxWithToStrLen) {
            value /= 10;
        }
        value += (int) Math.pow(10, toStrLen);
        String cv = String.valueOf(value);
        cv = cv.substring(1, toStrLen + 1);
        return cv;
    }

    public static boolean checkSymetryString(String checkStr) {
        Stack stack = new Stack();
        for (int i = 0; i < checkStr.length(); i++) {
            stack.push(checkStr.charAt(i));
        }
        String symetryStr = "";

        while (!stack.isEmpty()) {
            symetryStr = symetryStr + stack.pop();
        }
        if (checkStr.equals(symetryStr)) {
            return true;
        } else {
            return false;
        }
    }

    public static String checkSymetryStringVer2(String checkStr) {

        Stack stack = new Stack();
        for (int i = 0; i < checkStr.length(); i++) {
            stack.push(checkStr.charAt(i));
        }
        int length = checkStr.length();

        for (int i = 2; i <= length - 2; i++) {
            for (int j = 0; j <= length; j += i) {
                if (j + i > length) {
                    break;
                }
                String cutStr = checkStr.substring(j, j + i);
                String endStr = checkStr.substring(j + i, length);

                if (checkSymetryString(cutStr) && endStr.length() < 2) {
                    if (endStr.length() == 1) {
                        break;
                    } else {
                        System.out.println("Day la chuoi doi xung");
                        break;
                    }
                }
                checkSymetryStringVer2(endStr);
            }
        }
        return null;

    }

}
