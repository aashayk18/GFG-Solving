//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[]=new boolean[V];
        boolean stack[]=new boolean[V];
        
        for(int i=0;i<adj.size();i++)
        {
            if(!visited[i])
            {
                if(iscycleutil(adj,i,visited,stack))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean iscycleutil(ArrayList<ArrayList<Integer>> adj,int curr,boolean visited[], boolean stack[])
    {
        visited[curr]=true;
        stack[curr]=true;
        
        for(int i=0;i<adj.get(curr).size();i++)
        {
            int dest=adj.get(curr).get(i);
            if(stack[dest])
            {
                return true;
            }else if(!visited[dest] && iscycleutil(adj,dest,visited,stack))
            {
                return true;
            }
        }
        stack[curr]=false;
        
        return false;
    }
}
