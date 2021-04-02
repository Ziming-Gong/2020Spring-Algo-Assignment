package edu.northeastern.ziming;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Q-1 ST Com:O(n)
        ListNode<Integer> node1 = getNode1();
        ListNode<Integer> node2 = getNode2();
        areConverging(node1, node2);
        System.out.println(areConverging(node1, node2));

        //Q-2 ST Com:O(n)
        BinaryTree<Integer> tree = new BinaryTree<>();
        initTree(tree);
        tree.printPerimeter();

        //Q-3 ST Com:O(n)
        int[] arr = {0,1,0,1,1,0,1,1,1,0,0,0};
        System.out.println(getMaxConsecutiveOnes(arr));

        //Q-4 ST Com: O(n)
        int[] arr1 = {2,4,4,4,6,7,7,7,8,9,9,9};
        System.out.println(getIndex(arr1, 7));

    }

    private static ListNode<Integer> getNode1(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addtail(1);
        list.addtail(2);
        list.addtail(3);
        list.addtail(7);
        list.addtail(8);
        list.addtail(9);


        return list.head;
    }
    private static ListNode<Integer> getNode2(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addtail(4);
        list.addtail(5);
        list.addtail(6);
        list.addtail(7);
        list.addtail(8);
        list.addtail(9);
        return list.head;
    }


    public static boolean areConverging(ListNode n1, ListNode n2){
        if( n1 == null || n2 == null){
            return false;
        }

        ListNode ptr1 = n1;
        ListNode ptr2 = n2;

        while (ptr1.next != null) {
            ptr1 = ptr1.next;
        }
        //ptr1 = ptr1.next;
        while (ptr2.next != null) {
            ptr2 = ptr2.next;
        }
       // ptr2 = ptr2.next;

        if(ptr1.data == ptr2.data ){
            return true;
        }
        return false;

    }



    private static void initTree(BinaryTree<Integer> tree){

        tree.root = new TreeNode<>(1);

        tree.root.left = new TreeNode<Integer>(2);
        tree.root.right = new TreeNode<Integer>(3);

        tree.root.left.left = new TreeNode<Integer>(4);
        tree.root.left.right = new TreeNode<Integer>(5);
        tree.root.right.left = new TreeNode<Integer>(6);
        tree.root.right.right = new TreeNode<Integer>(7);

        tree.root.left.left.left = new TreeNode<Integer>(8);
        tree.root.left.left.right = new TreeNode<Integer>(9);
        tree.root.left.right.left = new TreeNode<Integer>(10);
        tree.root.left.right.right = new TreeNode<Integer>(11);

        tree.root.right.left.right = new TreeNode<Integer>(13);
        tree.root.right.right.left = new TreeNode<Integer>(14);

    }

    private static int getMaxConsecutiveOnes(int[] nums){
        int count = 0;
        int max = 0;
        for( int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                if(count > max){
                    max = count;
                }
            }else {
                count = 0;
            }
        }
        return max;
    }

    private static int getIndex(int[] arr, int x){
        if(arr == null){
            return 0;
        }
        int ptr = 0;
        for( int i = 0; i < arr.length; i ++){
            if (arr[i] == x) {
                ptr = i;
                break;
            }
        }
        return ptr;
    }
}
