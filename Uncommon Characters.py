#User function Template for python3

class Solution:
    def UncommonChars(self,A, B):
        #code here
        c=set(A).symmetric_difference(set(B))
        c=sorted(list(c))
        d="".join(c)
        return d if d != "" else -1


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())

    for tcs in range(T):
        A = input()
        B = input()
        ob = Solution()
        print(ob.UncommonChars(A, B))

# } Driver Code Ends
