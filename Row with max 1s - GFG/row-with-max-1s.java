//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int cnt(int arr[]){
        int first=-1,low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==1){
                first=mid;
                high=mid-1;
            }else if(arr[mid]<1){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(first!=-1){
            return arr.length-first;
        }
        return 0;
    }
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int ans=-1,count=0;
        for(int i=0;i<arr.length;i++){
            int temp=cnt(arr[i]);
            if(temp>count){
                count=temp;
                ans=i;
            }
        }
        return ans;
        
    }
}