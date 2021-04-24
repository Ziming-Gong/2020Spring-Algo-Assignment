package edu.northeastern.ziming;

public class Edge {

    public String startNode;
    public String endNode;
    public int weight;

    public Edge(String startNode, String endNode, int weight){
        this.endNode = endNode;
        this.startNode = startNode;
        this.weight = weight;
    }
}
