//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        HashMap<Integer, Integer> track = new HashMap<>();
        int ans = -1;
        
        for(int i=0; i<a.length; i++) {
            if(track.containsKey(a[i])) {
                track.put(a[i], track.get(a[i]) + 1);
            } else {
                track.put(a[i], 1);
            }
        }
        for(Integer key : track.keySet()) {
            if(track.get(key) > size/2) {
                ans = key;
            }
        }
        return ans;
    }
}
