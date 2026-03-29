import java.util.*;

public class week3_a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any String:");
		String s=sc.next();
		System.out.println("Enter any key:");
		int k=sc.nextInt();
		String a=en(s,k);
		String b=de(a,k);
		System.out.println("encripted string : "+" "+a);
		System.out.println("decripted String : "+" "+b);
	}
	public static String en(String s , int k) {
		k=k%26;
		StringBuilder sb=new StringBuilder();
		for(char c:s.toCharArray()) {
			if(Character.isLowerCase(c)) {
				c+=k;
				if(c>'z') c-=26;
			}
			if(Character.isUpperCase(c)) {
				if (c>'Z') c-=26;
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String de(String s , int k) {
		k=k%26;
		StringBuilder sb=new StringBuilder();
		for(char c:s.toCharArray()) {
			if(Character.isLowerCase(c)) {
				c-=k;
				if(c<'a') c+=26;
			}
			if(Character.isUpperCase(c)) {
				if(c<'A') c+=26;
			}
			sb.append(c);
		}
		return sb.toString();
	}

}
