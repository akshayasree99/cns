import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
public class week7 {
		public static String enc(String s, String key) throws Exception{
			SecretKeySpec sk=new SecretKeySpec(key.getBytes(),"Blowfish");
			
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, sk);
			byte a[]=cipher.doFinal(s.getBytes());
			return Base64.getEncoder().encodeToString(a);
		}
		public static String dec(String s, String key) throws Exception{
			SecretKeySpec sk=new SecretKeySpec(key.getBytes(),"Blowfish");
			
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE,sk);
			byte a[]=cipher.doFinal(Base64.getDecoder().decode(s));
			return new String(a);
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
				String key = "451017189";  
				String s = "HelloWorld";
				
				String en=enc(s,key);
				System.out.println("Blowfish ENcrpted: "+" "+en);
				
				String de=dec(en,key);
				System.out.println("Blowfish DECRipted : "+" "+de);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}


}
