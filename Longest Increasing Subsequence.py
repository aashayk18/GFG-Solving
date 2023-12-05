#User function Template for python3

class Solution:
    
    def just_greater(self,tail,value):
        low=0
        high=len(tail)-1
        while low<high:
            mid=(low+high)//2
            if tail[mid]<value:
                low=mid+1
            else:
                high=mid
        return high

    def longestSubsequence(self,a,n):
        tail=[a[0]]
        for item in a:
            if item>tail[-1]:
                tail.append(item)
            else:
                index=self.just_greater(tail,item)
                tail[index]=item
        return len(tail)
       



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    for _ in range(int(input())):
        n = int(input())
        a = [ int(x) for x in input().split() ]
        ob=Solution()
        print(ob.longestSubsequence(a,n))
# } Driver Code Ends
