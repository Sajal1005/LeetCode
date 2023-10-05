//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String str)
    {
        // your code here     
        if(str.length()%2!=0) return -1;
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(s.isEmpty()) s.push(str.charAt(i));
            else if(s.peek()=='{' && str.charAt(i)=='}') s.pop();
            else s.push(str.charAt(i));
        }
        int a=0,b=0;
        while(!s.empty()){
            if(s.peek()=='{') a++;
            else b++;
            s.pop();
        }
        return (a+1)/2 + (b+1)/2;
    }
}