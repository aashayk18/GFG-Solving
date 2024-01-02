//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxHistogram(int M[]) {
        // add code here.
        int max = 0;
        int nsr[] = new int[M.length];
        int nsl[] = new int[M.length];
        
        Stack<Integer> s = new Stack<>();
        for(int i = M.length-1; i >= 0; i--){
            while(!s.isEmpty() && M[s.peek()] >= M[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = M.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        
        s = new Stack<>();
        for(int i = 0; i < M.length; i++){
            while(!s.isEmpty() && M[s.peek()] >= M[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        
        for(int i = 0; i < M.length; i++){
            int height = M[i];
            int width = nsr[i] - nsl[i] - 1;
            int curr = height * width;
            max = Math.max(max, curr);
        }
        return max;
    }
    public int maxArea(int M[][], int n, int m){
        int currRow[] = M[0];
        int maxArea = maxHistogram(currRow);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(M[i][j] == 1){
                    currRow[j]++;
                }else{
                    currRow[j] = 0;
                }
            }
            int currArea = maxHistogram(currRow);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}
