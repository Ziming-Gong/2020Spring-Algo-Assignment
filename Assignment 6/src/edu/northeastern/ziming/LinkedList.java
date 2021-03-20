package edu.northeastern.ziming;

public class LinkedList {
    public ListNode head;

    public LinkedList(){

    }
    public void addtail(int data){

        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public int size(ListNode head){
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
    public  void printList(){
        ListNode temp = head;
        while (temp != null) {
            System.out.printf(temp.data+ "-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
}
