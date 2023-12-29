//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int count = 0;
        Stack<Integer> q = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                norDFS(adj, vis, i, q);
            }
        }
        
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reversedAdj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            for (int n: adj.get(i))
            reversedAdj.get(n).add(i);
        }
        
        Arrays.fill(vis, false);
        while (!q.isEmpty()) {
            int curr = q.pop();
            if (!vis[curr]) {
                revDFS(reversedAdj, vis, curr);
                count++;
            }
        }
        return count;
    }
    
    public void norDFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr, Stack<Integer> s) {
        vis[curr] = true;
        for (int n: adj.get(curr)) {
            if (!vis[n]) {
                norDFS(adj, vis, n, s);
            }
        }
        s.push(curr);
    }
    
    public void revDFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr) {
        vis[curr] = true;
        for (int n: adj.get(curr)) {
            if (!vis[n]) {
                revDFS(adj, vis, n);
            }
        }
    }
}
