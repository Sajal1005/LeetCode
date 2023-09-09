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
        Node list0 = new Node(0),list1=new Node(1),list2=new Node(2);
        Node l0=list0,l1=list1,l2=list2;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                l0.next=temp;
                temp=temp.next;
                l0=l0.next;
            }else if(temp.data==1){
                l1.next=temp;
                temp=temp.next;
                l1=l1.next;
            }else if(temp.data==2){
                l2.next=temp;
                temp=temp.next;
                l2=l2.next;
            }
        }
        if(l1==list1){
            l0.next=list2.next;
        }else{
            l0.next=list1.next;
            l1.next=list2.next;
        }
        l2.next=null;
        return list0.next;
        
    }
}


