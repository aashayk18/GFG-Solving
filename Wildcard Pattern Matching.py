# your task is to complete this function
# function should return True/False or 1/0
# str1: pattern
# str2: text
class Solution:
    def wildCard(self,p, s):
        # Code here
        i,j,si,m=0,0,-1,0
        while i<len(s):
            if j<len(p) and (s[i]==p[j] or p[j]=='?'):
                j+=1
                i+=1
            elif j<len(p) and p[j]=='*':
                si=j
                m=i
                j+=1
            elif si!=-1:
                j=si+1
                m+=1
                i=m
            else:
                return False
        while j<len(p) and p[j]=='*':
            j+=1
        return j==len(p)



#{ 
 # Driver Code Starts
if __name__=='__main__':
    t = int(input())
    for i in range(t):
        pattern = input().strip()
        string = input().strip()
        if Solution().wildCard(pattern, string):
            print(1)
        else:
            print(0)
# Contributed by: Harshit Sidhwa

# } Driver Code Ends
