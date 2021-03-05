package edu.northeastern.ziming;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //Find K Closest Elements
//        int[] arr = {0,0,1,2,3,3,4,7,8};
//        List<Integer> list = findClosestElements2(arr, 3,5);
//        printList(list);

        //sort two array
//        int[] arr1 = {1,2,2,1};
//        int[] arr2 = {2,2};
//        int[] twoArray = intersection(arr1, arr2);
//        printArr(twoArray);
//        System.out.println("");

        //Peak Index in a Mountain Array
//        int[] arr = {0,1,0};
//        System.out.println(peakIndexInMountainArray(arr));

        //reorganize
        String  S = "aab";
        String a = reorganizeString(S);
        System.out.println(a);


        //count 1's
//        int[] arr = {1,1,1,1,1,1,1,5,5,6,7,3,2};
//        System.out.println(countOnes(arr));




    }
    //Find K Closest Elements
    public static void printList(List<Integer> list){
        for (int i : list){
            System.out.printf(i + ",");
        }
        System.out.println();
    }
    public static void printArr(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i : arr) {
            System.out.printf(i + ", ");
        }
        System.out.println();
    }

    public static List<Integer> findClosestElements( int[] arr, int k, int x){
        List<Integer> result = new ArrayList<Integer>();
        for(int t : arr){
            result.add(t);
        }
        int low = 0;
        int high = arr.length-1;

        for ( int i = 0; i < arr.length - k; i ++){
            int remainder1 = Math.abs(result.get(low) - x);
            int remainder2 = Math.abs(result.get(high)- x);
            if (remainder1 > remainder2){
                result.remove(low);
                high--;
            }else if(remainder1 < remainder2){
                result.remove(high);
                high--;
            } else if (remainder1 == remainder2) {
                result.remove(high);
                high--;
            }
        }
        return result;
    }

    //second
    public static List<Integer> findClosestElements2(int[] arr, int k, int x){
        int low= 0;
        int high = arr.length -1;
        int[] result = new int[k];

        for( int i =0; i < arr.length - k; i ++){
            int remainder1 = Math.abs(arr[low] - x);
            int remainder2 = Math.abs(arr[high]- x);
            if (remainder1 > remainder2){
                low ++;
            }else if(remainder1 < remainder2){
                high--;
            } else if (remainder1 == remainder2) {
                high--;
            }
        }
        int j = 0;
        for ( int i = low; i <= high; i ++){

            result[j]= arr[i];
            j++;
        }
        List<Integer> list = Arrays.stream(result).boxed().collect(Collectors.toList());
        return list;
    }


    public static int[] intersection(int[] arr1, int[] arr2){
        int Range = Math.max(arr1.length, arr2.length);
        int[] result = intersection(arr1, arr2, Range);
        return deleteSameElements(result);
    }

    private static int[] intersection(int[] arr1, int[] arr2, int Range){
        int[] result = new int[Range];
        int index = 0;
        for(int i = 0; i < arr1.length; i++){
            for (int j = 0 ; j < arr2.length ; j ++){
                if(arr1[i] == arr2[j]){
                    result [index] = arr1[i];
                    index++;
                }
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }
    private static int[] deleteSameElements(int[] arr){
        Set<Integer> set = new HashSet<Integer>();
        for(int i : arr){
            set.add(i);
        }
        int[] delete = new int[set.size()];
        int index = 0;
        for( int i : set){
            delete[index++] = i;
        }
        return delete;
    }

    //Peak index in a mountain array
    public static int peakIndexInMountainArray(int[] arr){
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int mid = 1;
        while ( mid < arr.length-1){
            if (arr[mid]> arr[mid - 1] && arr[mid] > arr[mid +1]){
                return mid;
            }else{
                mid++;
            }
        }
        return -1;
    }



    //Reorganize String
    public static String reorganizeString(String string){
        int lenth = string.length();
        int[] arr = new int[26];
        for (char c: string.toCharArray()) arr[c-'a'] += 100;
        for (int i = 0; i < 26; ++i) arr[i] += i;
        Arrays.sort(arr);

        char[] chararr = new char[lenth];
        int index = 1;
        for (int i: arr) {
            int ct = i / 100;
            char ch = (char) ('a' + (i % 100));
            if (ct > (lenth+1) / 2) return "";
            for (int j = 0; j < ct; ++j) {
                if (index >= lenth) index = 0;
                chararr[index] = ch;
                index += 2;
            }
        }

        return String.valueOf(chararr);


    }

    //Count 1's in a sorted binary array
    public static int countOnes(int[] arr){
        int count = 0;
        for ( int i : arr){
            if (i == 1) {
                count++;
            }
        }
        return count;
    }



















}
