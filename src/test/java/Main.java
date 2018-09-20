import java.util.Scanner;

/**
 * @author: xiaolong
 * @Date: 下午8:20 2018/9/20
 * @Description:
 */
public class Main {
    public static final int maxn = 100;
    public static int[][] dp = new int[maxn][maxn];
    public static int[] bits = new int[maxn];
    public static int[] a = new int[maxn];
    public static int len;
    public static long dfs(int pos, int pre, boolean preFlag, int cnt, boolean flag) {
        if(pos < 0) {
            return 1;
        }
        if(!flag && dp[pos][pre] != -1) {
            return dp[pos][pre];
        }
        int up = flag ? bits[pos] : 9;
        int ret = 0;
        for(int i = 0;i <= up;i ++) {
            a[pos] = i;
//            System.out.println(pos + " -> " + i);
            if(pos <= (len - cnt - 1)/2 && a[len - pos - 1 - cnt] == i) {
                continue;
            }
            ret += dfs(pos - 1, i, preFlag && i == 0, cnt + ((preFlag == true && (i == 0 ? true : false) ) ? 1 : 0), flag && i == up);
        }
        if(!flag) {
            dp[pos][pre] = ret;
        }

        return ret;
    }
    public static long get(long x) {
        len = 0;
        while(x > 0) {
            bits[len++] = (int)(x % 10);
            x /= 10;
        }
        if(len == 0) {
            return 0;
        }
        return dfs(len - 1,-1, true, 0,true);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            for(int i = 0;i < maxn;i ++) {
                for(int j = 0;j < maxn;j ++) {
                    dp[i][j] = -1;
                }
            }
            long n = in.nextLong();
            long m = in.nextLong();
//            System.out.println(get(m));
//            System.out.println("--------");
//            System.out.println(get(n - 1));
            System.out.println(get(m) - get(n - 1));
        }
    }
}
