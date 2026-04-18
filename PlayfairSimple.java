import java.util.*;

public class PlayfairSimple {

    static char[][] m = new char[5][5];

    // Create matrix
    static void gen(String key) {
        boolean[] used = new boolean[26];
        key = key.toLowerCase().replace("j","i");
        String s = "";

        for(char c: key.toCharArray())
            if(!used[c-'a']) { used[c-'a']=true; s+=c; }

        for(char c='a'; c<='z'; c++)
            if(c!='j' && !used[c-'a']) s+=c;

        int k=0;
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                m[i][j]=s.charAt(k++);
    }

    static int[] pos(char c){
        if(c=='j') c='i';
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                if(m[i][j]==c) return new int[]{i,j};
        return null;
    }

    // Encrypt
    static String enc(String t){
        t=t.toLowerCase().replace("j","i").replaceAll(" ","");
        if(t.length()%2!=0) t+="x";

        String r="";
        for(int i=0;i<t.length();i+=2){
            int[] a=pos(t.charAt(i));
            int[] b=pos(t.charAt(i+1));

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

    // Decrypt
    static String dec(String t){
        String r="";
        for(int i=0;i<t.length();i+=2){
            int[] a=pos(t.charAt(i));
            int[] b=pos(t.charAt(i+1));

            if(a[0]==b[0]){
                r+=m[a[0]][(a[1]+4)%5];
                r+=m[b[0]][(b[1]+4)%5];
            } else if(a[1]==b[1]){
                r+=m[(a[0]+4)%5][a[1]];
                r+=m[(b[0]+4)%5][b[1]];
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
        String key=sc.nextLine();

        System.out.print("Text: ");
        String text=sc.nextLine();

        gen(key);

        String e=enc(text);
        String d=dec(e);

        System.out.println("Encrypted: "+e);
        System.out.println("Decrypted: "+d);
    }
}