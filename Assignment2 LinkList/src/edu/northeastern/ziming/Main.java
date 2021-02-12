package edu.northeastern.ziming;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkList<Integer> list = new LinkList<>();
//        list.addtail(1);
//        list.addtail(2);
//        list.addtail(3);
//        list.addtail(4);
//        list.addtail(5);
//        list.addtail(6);
//        list.addtail(7);

        //delete
//        list.deleteNode(5);
//        list.printList();

        //odd even list
//        oddevenList(list.head);
//        list.printList();
//        System.out.println("");

        //swap
//        swapPairs(list.head);
//        list.printList();
//        System.out.println("");

        //spilt
//        Node[] split = list.splitListToParts(list.head, 2);
//
//        System.out.println(split);

        //insert
        createCyclic(list);
        //list.printList();

        insertNode(list.head, 2);
        list.printList();
        System.out.println("");


      }
    public static  Node<Integer> swapPairs(Node<Integer> node){
        if (node == null || node.next == null) {
            return node;
        }
        Node<Integer> mid = node;
        Node<Integer> bac = null;
        while (mid != null && mid.next != null) {
            Node<Integer> temp = mid.next;
            mid.next = temp.next;
            temp.next = mid;
            mid = temp;
            if (bac != null) {
                bac.next = mid;
            }else {
                node =mid;
            }
            bac = mid.next;
            mid=bac.next;
        }
        return node;
    }


    public static Node<Integer> oddevenList(Node<Integer> node){
        if (node == null) {
            return node;
        }
        Node<Integer> odd = new Node<Integer>();
        Node<Integer> even = new Node<Integer>();
        Node<Integer> oddList = odd;
        Node<Integer> evenList = even;

        boolean isodd = true;

        while (node != null) {
            if (isodd) {
                oddList.next = node;
                oddList = oddList.next;
            }else {
                evenList.next= node;
                evenList = evenList.next;
            }
            node = node.next;
            isodd = !isodd;
        }
        oddList.next = even.next;
        evenList.next = null;
        return odd.next;
    }

    private static void createCyclic(LinkList<Integer> list){
        list.addtail(3);
        list.addtail(4);
        list.addtail(1);

        Node<Integer> startpoint = list.head;
        Node<Integer> tailNode = list.getTailNode();
        tailNode.next = startpoint;

    }

    public static Node<Integer> insertNode(Node<Integer> node, Integer insertdata){
        Node<Integer> NewNode = new Node<Integer>(insertdata);
        if (node == null) {
            NewNode.next = NewNode;
            return NewNode;
        } else {
            Node<Integer> mid = node;
            Node<Integer> front = mid.next;
            while (front != node) {
                if (mid.data <= insertdata && insertdata <= front.data) {
                    break;
                } else if (mid.data > front.data && insertdata <= front.data) {
                    break;
                } else if (mid.data > front.data && insertdata >= mid.data) {
                    break;
                } else {
                    mid = mid.next;
                    front = front.next;
                }
            }
            mid.next = NewNode;
            NewNode.next = front;
            return node;
        }


    }




}
