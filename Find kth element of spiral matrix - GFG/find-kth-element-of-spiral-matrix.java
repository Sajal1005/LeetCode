//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int arr[][], int n, int m, int k)
    {
	// Your code here	
	int top=0,left=0,right=m-1,down=n-1,dir=0,count=1;
	while(top<=down && left<=right){
	    if(dir==0){
	        for(int i=left;i<=right;i++){
	            if(count==k){
	                return arr[top][i];
	            }
	            count++;
	        }
	        top++;
	    }else if(dir==1){
	        for(int i=top;i<=down;i++){
	            if(count==k){
	                return arr[i][right];
	            }
	            count++;
	        }
	        right--;
	    }else if(dir==2){
	        for(int i=right;i>=left;i--){
	            if(count==k){
	                return arr[down][i];
	            }
	            count++;
	        }
	        down--;
	    }else if(dir==3){
	        for(int i=down;i>=top;i--){
	            if(count==k){
	                return arr[i][left];
	            }
	            count++;
	        }
	        left++;
	    }
	    dir=(dir+1)%4;
	}
	return -1;
    }
}