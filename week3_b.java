import java.util.*;

public class week3_b {
	public static String x="abcdefghijklmnopqrstuvwxyz";
	public static String y="zyxwvutsrqponmlkjihgfedcba";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any String:");
		String s=sc.next();
		String a=en(s);
		String b=de(a);
		System.out.println("encripted string : "+" "+a);
		System.out.println("decripted String : "+" "+b);
	}
	public static String en(String s) {
		StringBuilder ans=new StringBuilder();
		for(char c:s.toCharArray()) {
			int i=x.indexOf(c);
			if(i!=-1) ans.append(y.charAt(i));
			else ans.append(c);
		}
		return ans.toString();
	}
	public static String de(String s) {
		StringBuilder ans=new StringBuilder();
		for(char c:s.toCharArray()) {
			int i=y.indexOf(c);
			if(i!=-1) ans.append(x.charAt(i));
			else ans.append(c);
		}
		return ans.toString();
	}
}
