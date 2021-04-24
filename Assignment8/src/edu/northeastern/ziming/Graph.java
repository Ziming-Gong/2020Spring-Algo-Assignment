package edu.northeastern.ziming;

import java.util.*;

public class Graph {
    public HashMap<String ,Node> nodes;
    public Node startNode;
    public Graph(){
        nodes = new HashMap<>();
    }
    public  void initializeDijkstra(){

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");

        node1.addEdge("2", 7);
        node1.addEdge("3", 9);
        node1.addEdge("6", 14);

        node2.addEdge("1",7);
        node2.addEdge("3",10);
        node2.addEdge("4",15);

        node3.addEdge("1",9);
        node3.addEdge("2",10);
        node3.addEdge("4",11);
        node3.addEdge("6",2);

        node4.addEdge("2",15);
        node4.addEdge("3",11);
        node4.addEdge("5",6);

        node5.addEdge("4", 6);
        node5.addEdge("6", 9);

        node6.addEdge("1", 14);
        node6.addEdge("3", 2);
        node6.addEdge("5", 9);

        nodes.put(node1.name, node1);
        nodes.put(node2.name, node2);
        nodes.put(node3.name, node3);
        nodes.put(node4.name, node4);
        nodes.put(node5.name, node5);
        nodes.put(node6.name, node6);

    }
    public void dijkstraShortestPath(String startNode){
        if(!nodes.containsKey(startNode)){
            return;
        }

        Node currentNode = nodes.get(startNode);
        currentNode.distance = 0;
        currentNode.cameFrom = startNode;

        while (currentNode != null) {

            for (Edge edge  : currentNode.listEdges) {
                Node node = nodes.get(edge.endNode);
                if(currentNode.distance + edge.weight < node.distance){
                    node.distance = currentNode.distance + edge.weight;
                    node.cameFrom = currentNode.name;
                }
            }
            currentNode.visited = true;

            currentNode = null;
            for( Map.Entry<String, Node> entry : nodes.entrySet()){
                Node node = entry.getValue();
                if(node.visited == true){
                    continue;
                }
                if( currentNode == null){
                    currentNode = node;
                }else {
                    if( currentNode.distance > node.distance){
                        currentNode = node;

                    }
                }
            }
        }
//        System.out.println("At this point we should have the shortest distances");
//
//        for( Map.Entry<String, Node> entry : nodes.entrySet()){
//            Node node = entry.getValue();
//            System.out.println(node.name+ " " + node.distance +" ");
//        }
//
//        System.out.println("At this point we should have the shortest distances");
    }










}
