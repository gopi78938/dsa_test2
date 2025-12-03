package Problems;

import java.util.HashSet;
import java.util.Set;

public class ConnectedComponents {

    public static void main(String [] args){
        int res= countConn(5,new int[][]{{0,1},{1,2},{3,4}});
        System.out.println(res);
    }

    private static int countConn(int n, int[][] edges) {
       int parent[]=new int[n];
       Set<Integer> set=new HashSet<>();
       for(int i=0;i<n;i++){
           parent[i]=i;
       }

       for(int i=0;i< edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           dsu(u,v,parent);
       }
       for(int i=0;i<n;i++){
           set.add(findRoot(i,parent));
       }
       return set.size();
    }

    private static void dsu(int u, int v, int[] parent) {
       int rx=findRoot(u,parent);
       int ry=findRoot(v,parent);
       if(rx!=ry){
           parent[rx]=ry;
       }
    }

    private static int findRoot(int u, int[] parent) {
        while(parent[u]!=u)
        {
            parent[u]=parent[parent[u]];
            u=parent[u];
        }
        return u;
    }
}
