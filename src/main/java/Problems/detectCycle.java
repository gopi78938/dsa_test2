package Problems;

import java.util.ArrayList;

import java.util.List;



public class detectCycle {
    public static void main(String [] args){
        boolean res= cycle(3,new int[][]{{0,1},{1,2},{2,0}});
        System.out.println(res);
    }
    private static boolean cycle(int n, int[][] edges) {
        boolean visited[]=new boolean[n];
        boolean path[]=new boolean[n];
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i< edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i=0;i<n;i++){
            if(!visited[i] && dfs(visited,path,i,adjList)){


            }

        }



}

    private static boolean dfs(boolean[] visited, boolean[] path, int i, List<List<Integer>> adjList) {
        visited[i]=true;
        path[i]=true;
        for(int j=0;j< adjList.get(i).size();j++){
            int next=adjList.get(i).get(j);
            if(path[next]==true){
                return true;
            }
            if(!visited[next] && dfs(visited,path,next,adjList)){
                return  true;
            }


        }
    }
    }
