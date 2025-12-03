package Problems;

import java.util.ArrayList;
import java.util.List;

public class PathExists {

public static void main(String [] args){
   boolean res= findPath(4,new int[][]{{0,1},{0,2},{1,3},{3,4}},0,4);
   System.out.println(res);
}

private static boolean findPath(int n,int [][]arr,int src,int dest){
    if(arr.length==0){
        return false;
    }
    if(src==dest){
        return true;
    }
    boolean visited[] =new boolean[n+1];
    List<List<Integer>> list=new ArrayList<>();
    for(int i=0;i<=n;i++){
        list.add(new ArrayList<>());
    }
    for(int i=0;i< arr.length;i++){
        list.get(arr[i][0]).add(arr[i][1]);
    }
    dfs(list,visited,src);
    return visited[dest];


}
private static void dfs(List<List<Integer>> list, boolean[] vis, int src){

    vis[src]=true;
    for(int neigh: list.get(src)){
        if(!vis[neigh]){
            dfs(list,vis,neigh);
        }
    }

}
}
