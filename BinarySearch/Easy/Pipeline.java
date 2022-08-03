/*
Codeforces Round #176 (Div. 2)
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int mod = 1000000007;
    public static void main(String[] args) {

        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        long n=fs.nextLong();
        long k=fs.nextLong();

        long low=0;
        long high=k;
        long ans=-1;

        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(n,k,mid))
            {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        out.print(ans);
        out.close();
       
        out.println(ans);



        out.close();

    }
    public static long SumOfN(long n)
    {
        return (n*(n+1))/2;
    }

    public static boolean isPossible(long n,long k,long splitter)
    {
        long NumOfPipes=SumOfN((k))-SumOfN((k-splitter))-splitter+1;

        return NumOfPipes>=n;
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

