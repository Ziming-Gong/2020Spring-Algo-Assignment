package edu.northeastern.ziming;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkList<T> {
    public Node<T> head;

    public LinkList(){

    }

    public Node<T> findStartPoint(){
        if (head == null || head.next == null) {
            return null;
        }

        Node<T> front = head;
        Node<T> back = head;
        while (front.next != null) {
            front = front.next;
            if (front.next != null) {
                front = front.next;
                back = back.next;
            }
            if(front == back){
                break;
            }
        }
        if (front == null) {
            return null;
        }


        front = head;
        while (front != back){
            front =front.next;
            back = back.next;
        }
        return front;
    }

    public Node<T> getTailNode(){
        if (head == null || head.next == null) {
            return head;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
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
        temp.next= node;
    }


    public void printList(){
        Node<T> temp = head;
        while (temp != null) {
            System.out.printf(temp.data+ "->");
            temp = temp.next;
        }
        System.out.printf("null");
    }

    public void deleteNode(T data ){
        if (head == null) {
            return;
        }
        Node<T> front = head.next;
        Node<T> back = null;
        Node<T> mid = head;
        while (mid.data != data) {
            back = mid;
            mid = mid.next;
            front=front.next;
        }
        back.next=front;
    }



    public Node<T>[] splitListToParts(Node<T> node, int k){
        Node[] ans = new Node[k];
        int[] size = new int[k];
        if (node == null){
            return ans;
        }
        Node<T> head = node;
        int i = 0;
        while (node!=null){
            if (i>=size.length){
                i=0;
            }
            size[i]++;
            node = node.next;
            i++;
        }

        Node<T> temp = null;
        i = 0;
        while (head!=null){
            if (size[i]<1){
                i++;
            }
            if (ans[i]==null){
                ans[i] = new Node<T>(head.data);
                temp = ans[i];
            }else {
                temp.next = new Node<T>(head.data);
                temp = temp.next;
            }
            head = head.next;
            size[i]--;
        }
        return ans;



    }










































}
