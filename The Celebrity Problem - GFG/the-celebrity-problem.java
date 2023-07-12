//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	// code here 
    	for(int i=0;i<arr.length;i++){
    	    int flag=0;
    	    for(int j=0;j<arr[i].length;j++){
    	        if(arr[i][j]==1){
    	            flag=1;
    	        }
    	    }
    	    if(flag==0){
    	        for(int j=0;j<n;j++){
    	            if(arr[j][i]==0 && j!=i){
    	                flag=1;
    	                break;
    	            }
    	    }
    	    if(flag==0){
    	        return i;
    	    }
    	}}
    	return -1;
    }
}