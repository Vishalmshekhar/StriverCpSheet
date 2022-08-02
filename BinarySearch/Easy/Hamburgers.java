import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int mod = 1000000007;
    public static void main(String[] args) {

        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);

      String s="";
      s=fs.next();
      long nb=0,ns=0,nc=0;
      long pb=0,ps=0,pc=0;
      long r=0;
         nb=fs.nextLong();
         ns=fs.nextLong();
         nc=fs.nextLong();
         pb=fs.nextLong();
         ps=fs.nextLong();
         pc=fs.nextLong();
         r=fs.nextLong();
         long reqBread=0;
         long reqSausage=0;
         long reqCheese=0;

         for(int i=0;i<s.length();i++)
         {
             if(s.charAt(i)=='B')
             {
                 reqBread++;
             }
             else if(s.charAt(i)=='S')
             {
                 reqSausage++;
             }
             else {
                 reqCheese++;
             }
         }




         long ans=0;
         long left=0;
         long right=100000000000000L;

         while(left<=right)
         {
             long mid = left + (right-left)/2;
             if(isPossible(mid,reqBread, reqSausage, reqCheese, nb, ns, nc, pb, ps, pc, r)==true)
             {
               ans=mid;
               left=mid+1;
             }
             else {
                 right=mid-1;
             }
         }
         out.println(ans);



     out.close();

}
public static boolean isPossible(long i,long reqBread,long reqSausage,long reqCheese,long nb,long ns,long nc,long pb,long ps,long pc,long r)
    {
        long NoOfBread=reqBread*i-nb;
        long NoOfSausage=reqSausage*i-ns;
        long NoOfCheese=reqCheese*i-nc;

        if(NoOfBread < 0)
            NoOfBread = 0;
        if(NoOfSausage < 0)
            NoOfSausage = 0;
        if(NoOfCheese < 0)
            NoOfCheese= 0;

        long PriceBread=NoOfBread*pb;
        long PriceSausage=NoOfSausage*ps;
        long PriceCheese=NoOfCheese*pc;

        long total=PriceBread+PriceSausage+PriceCheese;

        if(total<=r)return true;
        return false;
    }
static long add(long a, long b) {
        return (a+b)%mod;
    }
    static long sub(long a, long b) {
        return ((a-b)%mod+mod)%mod;
    }
    static long mul(long a, long b) {
        return (a*b)%mod;
    }
    static long exp(long base, long exp) {
        if (exp==0) return 1;
        long half=exp(base, exp/2);
        if (exp%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];
    static void precompFacts() {
        factorials[0]=invFactorials[0]=1;
        for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--)
            invFactorials[i]=mul(invFactorials[i+1], i+1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }


    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }



}
