from collections import defaultdict

class Solution:
    def countDistinct(self, A, N, K):
        # Code here
        l = 0 
        ans = []
        map = defaultdict(int)
        for r in range(N):
            map[A[r]] += 1 
            if r - l + 1 == K:
                cnt = 0
                ans.append(len(map))
                map[A[l]] -= 1 
                if map[A[l]] == 0:
                    del map[A[l]]
                l += 1 
        return ans


#{ 
 # Driver Code Starts
if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n,k = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        res = Solution().countDistinct(arr, n, k)
        for i in res:
            print (i, end = " ")
        print ()
# } Driver Code Ends
