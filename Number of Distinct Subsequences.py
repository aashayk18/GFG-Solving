#User function Template for python3

class Solution:
	def distinctSubsequences(self, S):
		mod = 10**9 + 7
		n = len(S)
		sub = {}
		
		dp = [1] + [0] * n
		
		for i in range(1, n + 1):
		    dp[i] = 2 * dp[i-1] % mod
		    if S[i-1] in sub:
		        dp[i] = (dp[i] - dp[sub[S[i-1]]-1]) % mod
		    sub[S[i-1]] = i    
		
		return dp[-1]
		
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		s = input()

		ob = Solution()
		answer = ob.distinctSubsequences(s)
		print(answer)

# } Driver Code Ends
