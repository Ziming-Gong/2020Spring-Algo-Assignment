package edu.northeastern.ziming;

public class LinkedList<T> {

    public ListNode<T> head;
    public LinkedList(){

    }

    public void addtail(T data){
        ListNode<T> node = new ListNode<>(data);
        if (head == null) {
            head = node;
            return;
        }
        ListNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public  void printList(){
        ListNode<T> temp = head;
        while (temp != null) {
            System.out.printf(temp.data+ "-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public ListNode<T> getTailNode(){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<T> temp = head;
        while (temp.next != null) {
            temp =temp.next;
        }
        return temp;
    }


}
