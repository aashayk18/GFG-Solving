//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java
class Solution
{
	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0 ;
// get the total sum and create array of that size.
	    for(int i: arr) sum+=i;
	    boolean[] values = new boolean[sum+1];
	    values[0] = true;

	    // get all possible sum we can.
	    for(int num: arr){
	        for( int s=sum-1; s>=num; s-- ){
	            if(values[s-num])   values[s] = true ;
	        }
	    }
	    
	    int dif = (sum%2 == 0)? 0: 1;
	    int left = sum / 2, right = left;

	    // check from 0 difference sum means from middle of sum.
	    while(left>0){
	        if(values[left--]) return dif;
	        if(values[right++])    return dif;
	        dif+=2;
	    }
	    
	    return dif ;
	}
}
