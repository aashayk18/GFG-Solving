from collections import deque

class Solution:

    #Function to find the shortest distance of all the vertices
    #from the source vertex S.
    def dijkstra(self, V, adj, S):
        #code here
        dis=[float("inf") for i in range(V)]
        q=deque([])
        q.append([0,S])
        dis[S]=0
        while(len(q)!=0):
            cur=q.popleft()
            node=cur[-1]
            cur_dis=cur[0]
            for i in adj[node]:
                node_weight=i[-1]
                adj_node=i[0]
                if(cur_dis+node_weight<dis[adj_node]):
                    q.append([cur_dis+node_weight,adj_node])
                    dis[adj_node]=cur_dis+node_weight
            
        return dis


#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys


if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        V,E = map(int,input().strip().split())
        adj = [[] for i in range(V)]
        for i in range(E):
            u,v,w = map(int,input().strip().split())
            adj[u].append([v,w])
            adj[v].append([u,w])
        S=int(input())
        ob = Solution()
        
        res = ob.dijkstra(V,adj,S)
        for i in res:
            print(i,end=" ")
        print()
# } Driver Code Ends
