//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String str) {
        // code here
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='/' || str.charAt(i)=='*'){
                s.push(str.charAt(i));
            }else if(str.charAt(i)==')'){
                if(s.peek()=='(') return 1;
                else{
                    while(!s.isEmpty() && s.peek()!='('){
                        s.pop();
                    }
                    s.pop();
                }
            }
            // System.out.println(s);
        }
        return 0;
    }
}
        
