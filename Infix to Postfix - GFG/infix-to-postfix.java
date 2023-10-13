//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int prec(char c){
        if(c=='^') return 3;
        else if(c=='*' || c=='/') return 2;
        else if(c=='+' || c=='-') return 1;
        return -1;
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        String ans="";
        Stack<Character> s = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                ans+=c;
            }else if(c=='('){
                s.push(c);
            }else if(c==')'){
                while(!s.isEmpty() && s.peek()!='('){
                    ans+=(s.pop());
                }
                s.pop();
            }else{
                while(!s.isEmpty() && prec(s.peek())>=prec(c)){
                    ans+=s.pop();
                }
                s.push(c);
            }
        }
        while(!s.isEmpty()){
            ans+=s.pop();
        }
        return ans;
    }
}