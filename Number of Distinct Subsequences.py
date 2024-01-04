#User function Template for python3

class Solution:
	def distinctSubsequences(self, S):
		mod = 10**9 + 7
		n = len(S)
		sub = {} #empty set to store indices of characters in string 
		
		dp = [1] + [0] * n #list with length 'n' where first element is 1 and rest are 0
		
		for i in range(1, n + 1): #iterate through length of string, skipping the 1 and starting with the 0s
		    dp[i] = 2 * dp[i-1] % mod #doubles count of distinct subsequences from previous character
		                            #since for each new character added, number of distinct subsequences 
		                            #double from the previous count
		    if S[i-1] in sub: #checks if current character already exists in the set or not 
		                        #(since i starts from 1, to check for i=0 i.e. first element, 'i-1')
		        dp[i] = (dp[i] - dp[sub[S[i-1]]-1]) % mod #if the character already exists in the set, 
		                                                #that means it's a duplicate and the count of 
		                                                #distinct subsequences needs to be altered to remove
		                                                #the number that was added assuming that the character 
		                                                #was unique. the code line essentially removes the 
		                                                #distinct subsequences that were added to the count 
		                                                #since the last occurrence of the current character
		    sub[S[i-1]] = i #updates set with current character's index
		
		return dp[-1] #return last element in set, i.e. count of distinct subsequences  
		
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
