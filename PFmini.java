import java.util.*;

public class PFmini {
    static char[][] m = new char[5][5];
    static void gen(String k){
        String s="abcdefghiklmnopqrstuvwxyz"; // j removed
        k=(k+s).toLowerCase();
        String r="";
        for(char c:k.toCharArray())
            if(c!='j' && r.indexOf(c)==-1) r+=c;

        int x=0;
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                m[i][j]=r.charAt(x++);
    }

    static int[] f(char c){
        if(c=='j') c='i';
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                if(m[i][j]==c) return new int[]{i,j};
        return null;
    }
    static String enc(String t){
        t=t.replace("j","i").replace(" ","");
        if(t.length()%2!=0) t+="x";
        String r="";
        for(int i=0;i<t.length();i+=2){
            int[] a=f(t.charAt(i)), b=f(t.charAt(i+1));
            if(a[0]==b[0]){
                r+=m[a[0]][(a[1]+1)%5];
                r+=m[b[0]][(b[1]+1)%5];
            } else if(a[1]==b[1]){
                r+=m[(a[0]+1)%5][a[1]];
                r+=m[(b[0]+1)%5][b[1]];
            } else {
                r+=m[a[0]][b[1]];
                r+=m[b[0]][a[1]];
            }
        }
        return r;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Key: ");
        String k=sc.nextLine();
        System.out.print("Text: ");
        String t=sc.nextLine();
        gen(k);
        String e=enc(t);
        System.out.println("Encrypted: "+e);
    }
}