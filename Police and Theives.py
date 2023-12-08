#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

class Solution:
    def catchThieves(self, arr, n, k): 
        l1=[]#theif
        l2=[]#police
        for i in range(len(arr)):
            if arr[i]=='T':
                l1.append(i)
            else:
                l2.append(i)
        i=0#police
        j=0#theif
        count=0
        while i<len(l1) and j<len(l2):
            distance=abs(l1[i]-l2[j])
            if distance<=k:
                count+=1
                i+=1
                j+=1
            else:
                if l1[i]>l2[j]:#if police is at larger distance .
                    j+=1
                else:
                    i+=1#if theif is at larger distane
        return count
        

#{ 
 # Driver Code Starts.

if __name__=='__main__': 
	t = int(input())
	for _ in range(t):
		line1 = list(map(int, input().strip().split()))
		n = line1[0]
		k = line1[1]
		arr = list(input().strip().split())
		obj = Solution()
		print(obj.catchThieves(arr, n, k))


# } Driver Code Ends
