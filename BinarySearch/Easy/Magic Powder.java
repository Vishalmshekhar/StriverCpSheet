/*
Codeforces Round #350 (Div. 2), problem: (D1) Magic Powder - 1
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int mod = 1000000007;
    public static void main(String[] args) {

        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        ArrayList<Long>a=new ArrayList<>();
        ArrayList<Long>b=new ArrayList<>();

        long n= fs.nextLong();
        long k= fs.nextLong();

        for(int i=0;i<n;i++)
        {
            a.add(fs.nextLong());
        }
        for(int i=0;i<n;i++)
        {
            b.add(fs.nextLong());
        }

        long ans=0;
        long left=0;
        long right=100000000000000L;
        while(left<=right)
        {
            long mid=left + (right-left)/2;

            if(isPossible(mid,a,b,k))
            {
                ans=Math.max(mid,ans);
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }



        out.println(ans);



        out.close();

    }
    public static boolean isPossible(long mid,ArrayList<Long>a,ArrayList<Long>b,long k)
      { long need=0;
          for(int i=0;i<a.size();i++)
          {
              need+=Math.max(0L,(a.get(i)*mid)-b.get(i));
              if(need>k)return false;
          }

           return need<=k;
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
