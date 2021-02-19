package edu.northeastern.ziming;

public class LinkList<T> {
    public Node<T> head;

    public LinkList(){

    }

    public void addtail(T data){
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }


    public void printList(){
        Node<T> temp = head;
        while (temp != null) {
            System.out.printf(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node<T> findKthFromEnd(int k){
        if(k<0 || head == null){
            return null;
        }

        Node<T> back = head;
        Node<T> front = head;

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

    public int size(){
        int size = 0;
        Node<T> temp = head;
        while (temp != null) {
            size ++;
            temp = temp.next;
        }
        return size;
    }















}
