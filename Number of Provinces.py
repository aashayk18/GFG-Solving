#User function Template for python3

class Solution:
    def checkBFS(self,visit, adj,k):
        q=[k]
        visit[k]=1
        while(q):
            node=q.pop(0)
            p=adj[node-1]
            for i in range(len(adj[node-1])):
                if(visit[p[i]]==1 and visit[i+1]==0):
                    visit[i+1]=1
                    q.append(i+1)
        

    def numProvinces(self, adj, V):
        visit = [0] * (V + 1)
        c = 0
        for i in range(1, V + 1):  # Start from vertex 1
            if visit[i] == 0:
                self.checkBFS(visit, adj,i)
                # print(visit)
                c += 1
        return c


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        V=int(input())
        adj=[]
        
        for i in range(V):
            temp = list(map(int,input().split()))
            adj.append(temp);
        
        ob = Solution()
        print(ob.numProvinces(adj,V))
# } Driver Code Ends
