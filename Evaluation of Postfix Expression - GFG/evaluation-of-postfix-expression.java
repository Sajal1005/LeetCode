//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String str)
    {
        // Your code here
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                s.push(Integer.parseInt(str.charAt(i)+""));
            }else{
                int num1 = s.pop();
                int num2=s.pop();
                if(str.charAt(i)=='*'){
                    s.push(num1*num2);
                }else if(str.charAt(i)=='/'){
                    s.push(num2/num1);
                }else if(str.charAt(i)=='+'){
                    s.push(num1+num2);
                }else{
                    s.push(num2-num1);
                } 
            }
        }
        return s.pop();
    }
}