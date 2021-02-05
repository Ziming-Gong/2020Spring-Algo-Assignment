package edu.northeastern.ziming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T> {
    public Node<T> root;

    public BinaryTree() {

    }


    //minimum depth
    public int minDepth() {
        return minDepth(root);
    }

    private int minDepth(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int ldepth = minDepth(node.left);
        int rdepth = minDepth(node.right);

        if (node.left == null) {
            return rdepth + 1;
        } else if (node.right == null) {
            return ldepth + 1;
        } else return 1 + Math.min(ldepth, rdepth);

    }


    //sum of left leaves
    public int sumOfLL() {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<T> queue = new LinkedList<>();
        queue.add((T) root.left);
        queue.add(null);
        boolean bprint = false;
        while (queue.size() > 0) {
            Node<Integer> node = (Node<Integer>) queue.remove();
            if (node != null) {
                if (bprint == false) {
                    sum = node.data + sum;
                    bprint = true;
                }
                if (node.left != null) {
                    queue.add((T) node.left);
                }
                if (node.right != null) {
                    queue.add((T) node.right);
                }

            } else {
                if (queue.size() == 0) {
                    break;
                }
                bprint  = false;
                queue.add(null);
            }

        }
    return sum;
    }


    //find all leaves
    public List<List<Integer>> findleaves(Node<T> node){
        List<List<Integer>> reslist = new ArrayList<>();
        while (node != null) {
            List<Integer> list = new ArrayList<>();
            node = findleaves(node,list);
            reslist.add(list);
        }
        return  reslist;
        }
    private Node<T> findleaves (Node<T> node, List<Integer> list){
        if (root == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            list.add((Integer) node.data);
            return null;
        }
        if (node.left != null) {
            node.left = findleaves(node.left, list);
        }
        if (node.right != null) {
            node.right = findleaves(node.right,list);
        }
        return node;
        }



        // is balanced
    public boolean isBalanced (Node<T> node){
        if (node == null) {
            return true;
        }else return Math.abs(height(node.right) - height(node.left)) <=1 &&
                isBalanced(node.left)&&
                isBalanced(node.right);

    }
    private int height(Node<T> node){
        if(node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        return 1+Math.max(lheight,rheight);
    }

}