package edu.northeastern.ziming;

import java.util.HashMap;
import java.util.LinkedList;

public class Node {

    public String name;
    public Boolean visited;
    public LinkedList<Edge> listEdges;
    public Node parent;
    public int rank;

    public String cameFrom = "";
    public int distance = Integer.MAX_VALUE;
    //public HashMap<Integer, String> vertex = new HashMap<Integer, String>();
    public String currentSmall = "";

    public Node(String name){
        this.name = name.toUpperCase();
        this.visited = false;
        this.listEdges = new LinkedList<Edge>();
        this.parent = this;
        this.rank = 0;
    }

    public void addEdge(String endNode, int weight){
        endNode = endNode.toUpperCase();

        for( Edge edge : listEdges){
            if( edge.endNode == endNode){
                return;
            }
        }

        Edge edge = new Edge(name, endNode,weight);
        listEdges.add(edge);
    }
}
