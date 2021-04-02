package edu.northeastern.ziming;

import java.util.Stack;

public class BinaryTree<T> {
    public TreeNode<T> root;

    public BinaryTree(){

    }
    public void printPerimeter(){
        Stack<TreeNode<T>> stack = new Stack<>();
        printPerimeter(root, 0 , 0, stack);
        while (!stack.isEmpty()){
            System.out.printf(stack.pop().data+ ", ");
        }
        System.out.println("");
    }
    private void printPerimeter(TreeNode<T> node, int left , int right, Stack<TreeNode<T>> stack){
        if (node != null) {
            if( node .left == null && node.right == null){
                System.out.printf(node. data+ ", ");
            }else{
                if (left == 0){
                    System.out.printf(node.data + ", ");
                }else if (right == 0 ){
                    stack.push( node);
                }
            }
            printPerimeter(node.right, left, right +1, stack);
            printPerimeter(node.left, left + 1, right, stack);
        }

    }
}
