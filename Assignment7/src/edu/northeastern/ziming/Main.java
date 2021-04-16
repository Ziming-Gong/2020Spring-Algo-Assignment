package edu.northeastern.ziming;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Valid Anagram
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));

        //Longest Common Prefix
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println();

        //set zero
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZero(matrix);
        System.out.println();

        //reverse words
        String rw = "I love you";
        System.out.println(reverseWords(rw));

        //rotate image
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage(m);
        System.out.println();








    }


    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] table = new int[26];
        for( int i = 0; i < s.length(); i++){
            table[s.charAt(i) - 'a']++;
        }
        for( int j = 0; j < t.length(); j ++){
            table[t.charAt(j)-'a']--;
            if (table[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0)
            return "";
        String pre = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<pre.length() && j < strs[i].length();j++) {
                if(pre.charAt(j) != strs[i].charAt(j))
                    break;
            }
            pre = pre.substring(0, j);
            if(pre.equals(""))
                return pre;
        }
        return pre;

    }

    public static void  setZero(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();

        for( int i = 0; i < row ; i ++){
            for( int j = 0; j < col; j ++){
                if(matrix[i][j] ==0 ){
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        for( int i = 0; i < row ; i++){
            for (int j = 0; j < col; j ++){
                if(row_zero.contains(i)||col_zero.contains(j)){
                    matrix[i][j]= 0;
                }
            }
        }
    }

    public static String reverseWords(String s){
        //delete the space
        s = s.trim();

        int ptr = s.length() - 1;
        int i = ptr;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            //find the first space
            while(i >= 0 && s.charAt(i) != ' ')
                i--;
            sb.append(s.substring(i + 1, ptr + 1) + " ");
            while(i >= 0 && s.charAt(i) == ' ')
                i--;
            ptr = i;
        }
        return sb.toString().trim();
    }

    public static void rotateImage(int[][] matrix){
        int length = matrix.length;
        //因为是对称的，只需要计算循环前半行即可
        for (int i = 0; i < length / 2; i++)
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                int m = length - j - 1;
                int n = length - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }

    }


}
