package edu.northeastern.ziming;

public class DoubleLinkList<T> {
    public Node<T> head;
    public Node<T> last;

    public DoubleLinkList(){

    }

    public void doubleAddTail(T data){
        Node<T> node = last;
        last = new Node<>(data);
        last.prev = node;
        if (node != null) {
            node.next = last;
        }

//        Node<T> node = new Node<>(data);
//        if (head == null) {
//            head= node;
//            return;
//        }
//        Node<T> temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = node;
//        node.prev = head;
//        head = node;

    }

    public void doubleAddHead(T data){
        Node<T> temp=head;
        head=new Node<>(data);

        head.next=temp;
        if(temp!=null){

            temp.prev=head;

        }
    }

    public void printDoubleList(){
        if (head != null) {
            Node<T> temp = head;
            System.out.printf("positive");
            while (temp.next != null) {
                System.out.printf(temp.data +"->");
                temp=temp.next;
            }
            System.out.printf(temp.data +"->");
            System.out.println("Null");
            System.out.printf("negative:");
            while (temp != null) {
                System.out.printf(temp.data + "->");
                temp=temp.prev;
            }
            System.out.println("Null");
        }else {
            Node<T> temp = last;
            System.out.printf("negative");
            while (temp.prev != null) {
                System.out.printf(temp.data +"->");
                temp=temp.prev;
            }
            System.out.printf(temp.data +"->");
            System.out.println("Null");
            System.out.printf("positive:");
            while (temp != null) {
                System.out.printf(temp.data + "->");
                temp=temp.next;
            }
            System.out.println("Null");
        }
    }

    public int size(){
        if (head != null) {
            int size =0;
            Node<T> temp = head;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            return size;
        }else {
            int size =0;
            Node<T> temp = last;
            while (temp != null) {
                size++;
                temp = temp.prev;
            }
            return size;
        }
    }






}
