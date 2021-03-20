package edu.northeastern.ziming;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Subtree of another tree
        BinaryTree tree = new BinaryTree();
        boolean isSubTree = tree.isSubTree(getTreeS(),getTreeT());
        System.out.println(isSubTree);

        //Sum of three
        int[] list = {-1,0,3,-5,5,1,-3,2};
        System.out.println( threeSum(list));

        //Generate Parentheses
        System.out.println(generateParentheses(3));
        generateParentheses(3);

        //asteroid Collision
        int[] arr = {-2,-1,1,2};
        int[] asteroid = asteroidCollision(arr);
        for(int i : asteroid){
            System.out.print(i+", ");
        }

        //Reverse Nodes in k-Group
        ListNode listNode = getLinkNode();
        ListNode reverse = reverseKGroup(listNode, 3);
        printList(reverse);

    }
    public static ListNode getLinkNode(){
        LinkedList list = new LinkedList();
        list.addtail(1);
        list.addtail(2);
        list.addtail(3);
        list.addtail(4);
        list.addtail(5);
        list.addtail(6);
        list.addtail(7);
        list.addtail(8);
        list.addtail(9);
        list.addtail(10);

        return list.head;
    }

    //SubTree of another tree
    public static Node getTreeS(){
        Node node = new Node(8);

        node.left = new Node(3);
        node.right = new Node(10);

        node.left.left = new Node(1);
        node.left.right = new Node(6);
        node.right.right = new Node(14);

        node.left.right.left = new Node(4);
        node.left.right.right = new Node(7);

        node.right.right.left = new Node(13);
        return node;
    }
    public static Node getTreeT(){
        Node node = new Node(6);

        node.left = new Node(4);
        node.right = new Node(7);

        return node;
    }

    //Sum of three
    public static List<List<Integer>> threeSum(int[] arr){
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length-1;
        int third = 0;
        List<List<Integer>> arrayList = new ArrayList<>();
        if (arr == null || arr.length <3) {
            return arrayList;
        }

        int sum;
        while(low < high){

            sum = arr[low] + arr[high];
            for( int i = low +1; i < high; i++){
                if ( arr[i] == -sum){
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[low]);
                    list.add(arr[high]);
                    arrayList.add(list);

                }
            }
            if(sum >= 0){
                high--;
            }else {
                low ++;
            }
        }
        removeDuplicate(arrayList);
        return arrayList;
    }
    private static List<List<Integer>> removeDuplicate(List<List<Integer>> list){
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
        return list;
    }


    //Generate Parentheses
    public static List<String> generateParentheses(int n){
        List<String> list = new ArrayList<>();
        generateParentheses(list, "", n,0);
        return list;

    }
    private static void generateParentheses(List<String> list, String str, int low, int high){
        if (low == 0 && high == 0) {
            list.add(str);
            return;
        }
        if(low > 0){
            generateParentheses(list, str+"(", low-1, high +1 );
        }
        if (high > 0) {
            generateParentheses(list, str+")", low, high-1);
        }
    }


    //Asteroid Collision
    public static int[] asteroidCollision(int[] arr){
        int[] result = new int[arr.length];
        int index =-1;
        for(int i=0;i<arr.length;i++){
            int value =arr[i];
            if(index == -1){
                result[++index]=value;
            }
            else{
                if(result[index]* value >0){
                    result[++index] =value;
                }
                else{
                    if(value >0)
                        result[++index] =value;
                    else{
                        if(result[index] + value <0)
                        {
                            index--;
                            i--;
                        }
                        else if(result[index] + value ==0){
                            index--;
                        }
                    }
                }
            }
        }
        int[] newArr = new int[index+1];
        for(int i=0;i<=index;i++){
            newArr[i]=result[i];
        }
        return newArr;

    }

    //Reverse Nodes in k-Group




    private static ListNode reverseBetweenMandN(ListNode node, int m, int n, int remainder, int j){
        ListNode back;
        if(j ==1 &&remainder ==0){
             back = null;
        }else {
             back = findKthFromHead(node, n);
        }
        ListNode mid = findKthFromHead(node,m);
        ListNode front= findKthFromHead(node, m).next;
            for(int i =m; i < n-1; i ++){
                if (front != null) {
                    mid.next = back;
                    back = mid;
                    mid = front;
                    front = front.next;
                }

            }


        mid.next = back;
        node = mid;
        return node;
    }
    public  static void printList(ListNode node){
        ListNode temp = node;
        while (temp != null) {
            System.out.printf(temp.data+ "-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    private static int size(ListNode node){
        ListNode temp = node;
        int count =0;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }
        return count;
    }
    private static ListNode findKthFromHead(ListNode node, int k){
        ListNode temp = node;
        for ( int i = 0; i <k ; i ++){
            if (temp.next == null) {
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }


    public static ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
       // ListNode end = dummy;
        int remain = size(head)/k;
        int remainder = size(head)%k;
        for( int i =0; i < remain; i++){
                int j = remain-i;
                ListNode start = pre.next;
                pre.next = reverseBetweenMandN(head,i*k, (i+1)*k, remainder, j);
                pre = start;
                //end = pre;
                head = dummy.next;
            }
        return dummy.next;
    }



































}
