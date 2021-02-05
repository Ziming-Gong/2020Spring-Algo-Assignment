package edu.northeastern.ziming;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinaryTree<Integer> tree = new BinaryTree<>();
        initTree(tree);
        boolean isbalance = tree.isBalanced(tree.root);
        System.out.println(isbalance);

    }

    public static void initTree(BinaryTree<Integer> tree){

        tree.root = new Node<Integer>(1);

        tree.root.left = new Node<Integer>(2);
        tree.root.right = new Node<Integer>(3);

        tree.root.left.left = new Node<Integer>(10);
        tree.root.left.right = new Node<Integer>(5);
        //tree.root.right.left = new Node<Integer>(6);
        //tree.root.right.right = new Node<Integer>(7);

        tree.root.left.left.right = new Node<Integer>(2);
        tree.root.left.left.left = new Node<Integer>(33);
    }
}
