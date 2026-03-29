import java.security.MessageDigest;
import java.util.*;
public class week11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter text to convert: ");
			String s=sc.next();
			
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte b[]=md.digest();
			
			String ans=get(b);
			System.out.println("MD5 hash of given text is: "+ans);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public static String get(byte by[]) {
		StringBuilder sb=new StringBuilder();
		for(byte b:by) {
			sb.append(String.format("%02X",b));
		}
		return sb.toString();
	}

}
