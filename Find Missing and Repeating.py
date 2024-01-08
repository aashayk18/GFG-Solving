#User function Template for python3

class Solution:
    def findTwoElement( self,arr, n): 
        # code here
        i = 0
        curr = 0
        res = []
        while(i<n):
            if arr[i] != arr[arr[i] - 1]:
                curr = arr[i]
                arr[i] = arr[arr[i] - 1]
                arr[curr - 1] = curr
            else:
                i = i+1
                
        for i in range(n):
            if arr[i] != i+1:
                res.append(arr[i])
                res.append(i+1)
        return res
            


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 

    tc=int(input())
    while tc > 0:
        n=int(input())
        arr=list(map(int, input().strip().split()))
        ob = Solution()
        ans=ob.findTwoElement(arr, n)
        print(str(ans[0])+" "+str(ans[1]))
        tc=tc-1
# } Driver Code Ends
