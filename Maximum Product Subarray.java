//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long maxProductLeft = Integer.MIN_VALUE;
        long maxProductRight = Integer.MIN_VALUE;
        long curProductLeft = 1;
        long curProductRight = 1;
        
        
        for(int i = 0, j = n-1 ; i < n; i++,j--){
            curProductLeft *= arr[i];
            curProductRight *= arr[j];
            
            maxProductLeft = Math.max(curProductLeft, maxProductLeft);
            maxProductRight = Math.max(curProductRight, maxProductRight);
            
            if(curProductLeft == 0) curProductLeft = 1;
            if(curProductRight == 0) curProductRight = 1;
        }
        
        return Math.max(maxProductLeft, maxProductRight);
    }
}
