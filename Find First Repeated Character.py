#User function Template for python3

class Solution:

    def firstRepChar(self, s):
        # code here
        chars=list()
        for i in s:
            if i in chars:
                return i
            else:
                chars.append(i)
        return -1


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

    t = int(input())

    for _ in range(t):
        s = input()

        solObj = Solution()

        print(solObj.firstRepChar(s))
# } Driver Code Ends
