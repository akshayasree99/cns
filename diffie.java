import java.util.*;
public class diffie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter modulo: ");
		int p=sc.nextInt();
		System.out.println("enter primitive roof of "+p);
		int g=sc.nextInt();
		System.out.println("enter secret num of alice: ");
		int a=sc.nextInt();
		System.out.println("enter secret num of bob: ");
		int b=sc.nextInt();
		
		int A=(int)Math.pow(g,a)%p;
		int B=(int)Math.pow(g,b)%p;
		
		int sa=(int)Math.pow(B,a)%p;
		int sb=(int)Math.pow(A,b)%p;
		if(sa==sb) {
			System.out.println("both can communicate with key: "+sa);
		}
		else {
			System.out.println("Both cant communicate");
		}
	}
}
