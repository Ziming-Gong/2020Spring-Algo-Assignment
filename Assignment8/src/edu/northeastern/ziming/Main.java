package edu.northeastern.ziming;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // find all vertices
//        Graph graph = new Graph();
//        String startNode = "1";
//        graph.initializeDijkstra();
//        findAllVertx(graph,startNode);
//        //graph.printAllPaths("1","4");
//
//        //courses Schedule
//        int number = 2;
//        int[][] pre = {{1,0},{0,1}};
//        System.out.println("the students could finish their courses:" +canFinished(number,pre));

        //Word Ladder
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        ladderLength("hit", "cog", wordList);
        System.out.println(ladderLength("hit", "cog", wordList));


        //island
        //Hi Ta
        //I don't know why the result is not correct
        //but I have submitted in LeetCode successfully
        //I guess the reason of that is the difference of "grid"
        //Could you please comment on Canvas? Thank you
        char[][] grid = {{1,1,0,0,0},
                         {1,1,0,0,0},
                         {0,0,1,0,0},
                         {0,0,0,1,1}};
        numIslands(grid);

        System.out.println(numIslands(grid));





        }

    public static void findAllVertx(Graph graph,String startNode) {
        graph.dijkstraShortestPath(startNode);
        System.out.println("From " +startNode+ " to all vertices");
        HashMap<String, Node> nodes = graph.nodes;
        Set<String> strings = nodes.keySet();
        for (String string : strings) {
            if ("1".equals(string)) {
                System.out.println("1->1");
            } else {
                StringBuilder resStrB = new StringBuilder();
                Node node = nodes.get(string);
                while (!("1".equals(node.name))) {
                    resStrB.append(node.name).append(">-");
                    node = nodes.get(node.cameFrom);
                }
                resStrB.append(1);
                System.out.println(resStrB.reverse());
            }
        }
    }

    // courses finished
    public static boolean canFinished(int numCourses, int[][] prerequisites){
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            inDegrees[p[0]]++;
            adjacency.get(p[1]).add(p[0]);
        }
        for(int i = 0; i <numCourses; i ++){
            if(inDegrees[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for( int i : adjacency.get(pre)){
                if( -- inDegrees[i] == 0)
                    queue.add(i);
            }
        }
        return numCourses == 0;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        if (!wordList.contains(endWord)){
            return 0;
        }

        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        int step=1;
        if (!wordSet.contains(endWord)) return 0;
        while(!start.isEmpty()){
            step++;
            HashSet<String> set=new HashSet<>();
            wordSet.removeAll(start);
            for(String s:start){
                char[] arr=s.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char ch=arr[i];
                    for(char c='a';c<='z';c++){
                        if(ch==c) continue;
                        arr[i]=c;
                        String str=new String(arr);
                        if(wordSet.contains(str)){
                            if(end.contains(str)){
                                return step;
                            }else{
                                set.add(str);
                            }
                        }
                    }
                    arr[i]=ch;
                }
            }
            if(set.size()<end.size()){
                start=set;
            }else{
                start=end;
                end=set;
            }

        }
        return 0;




    }

    //Island
    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private  static void bfs(char[][] grid, int i, int j){
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[] { i, j });
        while(!list.isEmpty()){
            int[] currentNode = list.remove();
            i = currentNode[0]; j = currentNode[1];
            if(0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[] { i + 1, j });
                list.add(new int[] { i - 1, j });
                list.add(new int[] { i, j + 1 });
                list.add(new int[] { i, j - 1 });
            }
        }
    }






}


