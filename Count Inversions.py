class Solution:
    #User function Template for python3
    
    # arr[]: Input Array
    # N : Size of the Array arr[]
    #Function to count inversions in the array.
    def inversionCount(self, arr, n):
        return self.merge_sort_and_count(arr, 0, n - 1)

    def merge_sort_and_count(self, arr, left, right):
        count = 0
    
        if left < right:
            mid = (left + right) // 2
    
            count += self.merge_sort_and_count(arr, left, mid)
            count += self.merge_sort_and_count(arr, mid + 1, right)
            count += self.merge_and_count(arr, left, mid, right)
    
        return count
    
    def merge_and_count(self, arr, left, mid, right):
        count = 0
        temp = []
    
        i, j = left, mid + 1
    
        while i <= mid and j <= right:
            if arr[i] <= arr[j]:
                temp.append(arr[i])
                i += 1
            else:
                temp.append(arr[j])
                count += mid - i + 1
                j += 1
    
        temp.extend(arr[i:mid + 1])
        temp.extend(arr[j:right + 1])
        arr[left:right + 1] = temp
    
        return count


#{ 
 # Driver Code Starts
#Initial Template for Python 3

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER

@atexit.register

def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

if __name__=='__main__':
    t = int(input())
    for tt in range(t):
        n = int(input())
        a = list(map(int, input().strip().split()))
        obj = Solution()
        print(obj.inversionCount(a,n))
# } Driver Code Ends
