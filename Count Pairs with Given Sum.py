#User function Template for python3

from collections import Counter
class Solution:
    def getPairsCount(self, arr, n, k):
        new = dict(Counter(arr))
        output=0
        for i in arr:
            if k-i in new and new[k-i]!=0:
                new[i]-=1
                output+=new[k-i]
        return output
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n, k = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.getPairsCount(arr, n, k)
        print(ans)
        tc -= 1

# } Driver Code Ends
