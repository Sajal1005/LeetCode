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
        if(c=='^'){
            return 3;
        }else if(c=='*' || c=='/'){
            return 2;
        }else if(c=='+' || c=='-'){
            return 1;
        }
        return -1;
    }
    public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> st = new Stack<>();
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else if(Character.isLetterOrDigit(s.charAt(i))){
                ans+=s.charAt(i);
            }else if(s.charAt(i)==')'){
                while(st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }else{
                while(!st.isEmpty() && prec(st.peek())>=prec(s.charAt(i))){
                    ans+=st.pop();
                }
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()) ans+=st.pop();
        return ans;
    }
}