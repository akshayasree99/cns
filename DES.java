import java.util.*;
import javax.crypto.*;
public class DES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			KeyGenerator kg=KeyGenerator.getInstance("DES");
			kg.init(56);
			SecretKey key=kg.generateKey();
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter any string: ");
			String s=sc.next();
			
			Cipher cipher =Cipher.getInstance("DES");
			
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte a[]=cipher.doFinal(s.getBytes());
			String ans=Base64.getEncoder().encodeToString(a);
			
			System.out.println("encrtyped is : "+" "+ans);
			
			cipher.init(Cipher.DECRYPT_MODE,key);
			byte []b=cipher.doFinal(Base64.getDecoder().decode(ans));
			String ans2=new String(b);
			
			System.out.println("decrypted is : "+" "+ans2);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
	}

}
