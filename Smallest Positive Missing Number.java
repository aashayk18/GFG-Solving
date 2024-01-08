//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        //set all negative or 0 to Integer.MAX_VALUE        
        for (int i = 0; i < size; i++)
            if (arr[i] <= 0) arr[i] = Integer.MAX_VALUE;
        
        //if +ve value of arr[i] is in range 1 to size inclusive, then set arr[arr[i]] -ve. keep it -ve. 
        //-ve means element = index is present
        for (int i = 0; i < size; i++)
            if (Math.abs(arr[i]) <= size) 
                arr[Math.abs(arr[i]) - 1] = -Math.abs(arr[Math.abs(arr[i]) - 1]);
            
        //element that is not present is non-negative
        for (int i = 0; i < size; i++) 
            if (arr[i] > 0) return i + 1;

        //else its size+1 element
        return size + 1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends
