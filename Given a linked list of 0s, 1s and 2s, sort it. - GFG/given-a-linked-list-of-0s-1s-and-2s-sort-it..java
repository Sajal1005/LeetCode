//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node count0 = new Node(-1);
        Node count1 = new Node(-1);
        Node count2 = new Node(-1);
        Node c0=count0,c1=count1,c2=count2;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                c0.next=temp;
                temp=temp.next;
                c0=c0.next;
            }else if(temp.data==1){
                c1.next=temp;
                temp=temp.next;
                c1=c1.next;
            }else{
                c2.next=temp;
                temp=temp.next;
                c2=c2.next;
            }
        }
        if(count1.next==null){
            c0.next=count2.next;
            c2.next=null;
        }else{
            c0.next=count1.next;
            c1.next=count2.next;
            c2.next=null;
        }
        return count0.next;
    }
}


