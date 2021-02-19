package edu.northeastern.ziming;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //remove LinkedList
        LinkList<Integer> list = getLinkList();
        removeElements(list.head,6);
        list.printList();

        //swap nodes
        LinkList<Integer> list4 = getLinkList();
        swapNodes(list.head, 2);
        list.printList();

        //merge in between
        LinkList<Integer> list1 = getNode1();
        LinkList<Integer> list2 = getNode2();
        Node<Integer> result = mergeInBetween(list1.head,list2.head,3,4);

        //delete N nodes after m nodes of a linked list
        LinkList<Integer> list5 = getLinkList();
        Node<Integer> result1 = deleteNodes (list.head, 2,1);
        printList(result);

        DoubleLinkList<Integer> doubleByHead = getDoubleList2();
        DoubleLinkList<Integer> doubleByTail = getDoubleList1();
        //doubleLinkList.printDoubleList();
        int a = doubleByHead.size();
        int b = doubleByTail.size();
        doubleByHead.printDoubleList();
        doubleByTail.printDoubleList();
        System.out.println("");

    }

    public static DoubleLinkList<Integer> getDoubleList1(){
        DoubleLinkList list = new DoubleLinkList();
        list.doubleAddTail(1);
        list.doubleAddTail(2);
        list.doubleAddTail(3);
        list.doubleAddTail(4);
        list.doubleAddTail(5);

        return list;
    }

    public static DoubleLinkList<Integer> getDoubleList2(){
        DoubleLinkList list = new DoubleLinkList();
        list.doubleAddHead(1);
        list.doubleAddHead(2);
        list.doubleAddHead(3);
        list.doubleAddHead(4);
        list.doubleAddHead(5);

        return list;
    }

    public static void printList(Node<Integer> node){
        Node<Integer> temp = node;
        while (temp != null) {
            System.out.printf(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private static LinkList<Integer> getNode1(){
        LinkList<Integer> list = new LinkList<>();

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
        list.addtail(11);
        list.addtail(12);
        list.addtail(13);
        list.addtail(14);



        return list;
    }
    private static LinkList<Integer> getNode2(){
        LinkList<Integer> list = new LinkList<>();
        list.addtail(100000);
        list.addtail(100001);
        list.addtail(100002);


        return list;
    }


    private static LinkList<Integer> getLinkList(){
        LinkList<Integer> list = new LinkList<>();
        list.addtail(1);
        list.addtail(2);
        list.addtail(3);
        list.addtail(4);
        list.addtail(5);
        list.addtail(6);
        list.addtail(7);
        list.addtail(8);









        return list;
    }


    public static Node<Integer> removeElements(Node<Integer> node, Integer k){
        if (node == null) {
            return null;
        }

        Node<Integer> temp = node;
        Node<Integer> back = new Node<>(k-1);
        back.next = node;
        while (temp != null) {
            if (temp.data == k) {
                back.next = temp.next;
            }else {
                back.next = temp;
                back = back.next;
            }
            temp = temp.next;
        }
        return back.next;



        //recursion
//        node.next = removeElements(node.next, k);
//        if (node.data == k) {
//            return node.next;
//        }else {
//            return node;
//        }
    }

    public static int size(Node<Integer> node){
        int size = 0;
        Node<Integer> temp = node;
        while (temp != null) {
            size ++;
            temp = temp.next;
        }
        return size;
    }
    public static Node<Integer> findKthFromEnd(Node<Integer> node, Integer k){
        if(k<0 || node == null){
            return null;
        }

        Node<Integer> back = node;
        Node<Integer> front = node;

        for (int i = 0; i < k; i++){
            if (front == null) {
                return front;
            }
            front = front.next;
        }
        while (front != null) {
            back = back.next;
            front = front.next;
        }
        return back;
    }

    public static Node<Integer> swapNodes(Node<Integer> node, Integer k){
        if (k <= 0 || node == null) {
            return node;
        }
        int size = size(node);
        if (k > size) {
            return node;
        }
        Node<Integer> temp = node;
        Node<Integer> first = node;
        for (Integer i = 0; i < k-1 ; i ++){
            temp = temp.next;
            first = temp;
        }
        Node<Integer> second = findKthFromEnd(node, k);
        Integer n =first.data;
        first.data = second.data;
        second.data = n;
        return node;
    }

    public static Node<Integer> mergeInBetween(Node<Integer> node1, Node<Integer> node2, Integer a, Integer b){
        if(node1 == null || node1.next == null ){
            return null;
        }
        if (node2 == null) {
            return node1;
        }
        Node<Integer> removehead = node1;
        Node<Integer> temp2 = node2;
        while (removehead != null) {
            if (removehead.next.data == a) {
                break;
            }
            removehead = removehead.next;
        }
        Node<Integer> removeback = node1;
        while (removeback != null){
            if (removeback.data == b) {
                break;
            }
            removeback = removeback.next;
        }
        removehead.next = temp2;
        while (temp2.next != null) {
            temp2 =temp2.next;
        }
        temp2.next = removeback.next;
        return node1;
    }

    public static Node<Integer> deleteNodes(Node<Integer> node, int m,int n){
        if( m < 0 || n < 0 ){
            return node;
        }
        if (node == null) {
            return null;
        }
        Node<Integer> temp1 = node;
        Node<Integer> temp2 = node;
        while (temp1 != null) {
            for (int i = 0 ; i <m-1; i ++){
                temp1 = temp1.next;
                temp2 = temp2.next;
                if (temp1 == null) {
                    break;
                }
            }
            if (temp2 == null) {
                break;
            }
            for (int i = 0; i <n+1; i++){
                temp2= temp2.next;
                if (temp2 == null) {
                    break;
                }
            }
            temp1.next = temp2;
            temp1 = temp1.next;
        }
        return node;
    }















}
