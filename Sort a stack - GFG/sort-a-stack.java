//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    public void add(Stack<Integer> s,int n){
        if(s.isEmpty() || s.peek()<=n){
            s.push(n);
            return;
        }
        int num=s.pop();
        add(s,n);
        s.push(num);
    }
    public void sort2(Stack<Integer> s){
        if(s.isEmpty()){
		    return;
		}
		int num = s.pop();
		sort2(s);
		add(s,num);
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		sort2(s);
		return s;
	}
}