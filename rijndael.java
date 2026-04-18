import java.util.Base64;
import javax.crypto.*;
public class rijndael {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SecretKey key=get();
			String s="Hello,RijndaelAES!";
			
			String en=enc(s,key);
			System.out.println("ENcrpted: "+" "+en);
			
			String de=dec(en,key);
			System.out.println("DECRipted : "+" "+de);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static SecretKey get() throws Exception{
		KeyGenerator kg=KeyGenerator.getInstance("AES");
		kg.init(128);
		return kg.generateKey();
	}
	public static String enc(String s, SecretKey key) throws Exception{
		Cipher cipher=Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte []a=cipher.doFinal(s.getBytes());
		return Base64.getEncoder().encodeToString(a);
	}
	public static String dec(String s, SecretKey key) throws Exception{
		Cipher cipher =Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte a[]=cipher.doFinal(Base64.getDecoder().decode(s));
		return new String(a);
	}

}
