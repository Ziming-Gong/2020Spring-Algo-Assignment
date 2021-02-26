package edu.northeastern.ziming;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] arr1 = {3,2,4,1};
        int[] arr2 = {1,5,8,6,9};
        int[] color = {2,0,2,1,1,0};

//        sortColor(color);
//        printList(color);

//        int[] result = intersection(arr1, arr2);
//        printList(result);
//        System.out.println("");

//        findNthSmallest(arr1,7);
//        printList(arr1);

//        flip(arr1, 0,6);
//        printList(arr1);

        List<Integer> list = pancakeSort(arr1);
        System.out.println(list);




    }



    public static void printList(int[] arr){
        if (arr == null) {
            return;
        }

        for(int i : arr){
            System.out.printf(i+", ");
        }
        System.out.println();
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

    public static void findNthSmallest(int[] arr, int n){
        if (arr == null || n < 0 || arr.length ==0 || n >=arr.length) {
            return;
        }
        findNthSmallest( arr, n, 0, arr.length-1);
        System.out.println(arr[n-1]);
    }

    private static void findNthSmallest(int[] arr, int n, int low, int high){
        if (low < high) {
            int pos = partition(arr, low, high);
            findNthSmallest(arr, n ,low, pos-1);
            findNthSmallest(arr, n, pos+1, high);

        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int wall = low -1;

        for (int i = low ; i< high; i++){
            if(arr[i] < pivot){
                wall++;
                swap(arr, i ,wall);
            }
        }
        wall++;
        swap(arr, high, wall);
        return wall;
    }

    private static void swap(int[] arr, int i, int j){
        if (arr == null || i >= arr.length || j >= arr.length || i < 0 || j < 0 || arr.length <2) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

    public static void sortColor(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while(mid <= high){
            if(arr[mid] < 1){
                swap(arr, mid, low);
                mid ++;
                low ++;
            }else if(arr[mid] == 1){
                mid++;
            }else {
                swap(arr, mid, high);
                high--;
            }
        }
    }


    public static List<Integer> pancakeSort(int[] arr){
        List<Integer>ans=new ArrayList<>();
        int n=arr.length;
        while(n!=1){
            int max=0;
            for(int i=1;i<n;i++){
                if(arr[max]<arr[i]){
                    max=i;
                }
            }
            // if(max==n-1){
            //     continue;
            // }else
            if(max==0){
                ans.add(n);
                flip(arr,n);
            }
            if(max!=0&&max!=n-1){
                ans.add(max+1);
                flip(arr,max+1);
                ans.add(n);
                flip(arr,n);
            }
            n--;
        }
        return ans;
    }

    public static void flip(int[]A,int n){
        for(int i=0,j=n-1;i<j;i++,j--){
            int temp=A[i];
            A[i]=A[j];
            A[j]=temp;
        }
    }



}
