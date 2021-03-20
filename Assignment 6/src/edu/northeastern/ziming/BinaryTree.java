package edu.northeastern.ziming;

public class BinaryTree {

    Node root;

    //Subtree of another tree
    public  boolean isSubTree(Node tree, Node subTree){

        if (tree == null) {
            return false;
        }
        if (subTree == null) {
            return true;
        }
        return isSame(tree, subTree)||
                isSubTree(tree.left,subTree)||
                isSubTree(tree.right, subTree);
    }
    private  boolean isSame(Node node1, Node node2){
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.data == node2.data)&&isSame(node1.left, node2.left)&&
                isSame(node1.right,node2.right);
    }

}
