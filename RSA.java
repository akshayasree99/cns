import java.math.BigInteger;
import java.util.*;
public class RSA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter prime p: ");
		BigInteger p=sc.nextBigInteger();
		System.out.println("Enter prime q: ");
		BigInteger q=sc.nextBigInteger();
		
		BigInteger n=p.multiply(q);
		
		BigInteger phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		
		BigInteger e=get(phi);
		BigInteger d=e.modInverse(phi);
		
		System.out.println("Public key(e,n): ("+" "+e+" "+n+" )");
		System.out.println("Private key(d,n): ("+" "+d+" "+n+" )");
	}
	public static BigInteger get(BigInteger phi) {
		Random rand=new Random();
		BigInteger e;
		do {
			e=new BigInteger(phi.bitLength(),rand);
		}while(e.compareTo(BigInteger.ONE)<=0 || e.compareTo(phi)>=0 || !phi.gcd(e).equals(BigInteger.ONE));
		return  e;
	}
}
