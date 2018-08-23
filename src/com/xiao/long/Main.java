
import java.util.Scanner;

public class Main {

    final static int maxn = 1000 + 10;
    static int[] Val = new int[maxn];
    static int[] Vol = new int[maxn];
    static int[][] dp = new int[maxn][maxn];

    public static void main(String []args) {

        Scanner in = new Scanner(System.in);
        int Tcase = in.nextInt();
        while (Tcase -- > 0) {
            int n = in.nextInt(),m = in.nextInt();
            for (int i = 1;i <= n;i ++) {
                Val[i] = in.nextInt();
            }
            for (int i = 1;i <= n;i ++) {
                Vol[i] = in.nextInt();
            }

            for (int i = 0;i < maxn;i ++) {
                for (int j = 0;j < maxn;j ++) {
                    dp[i][j] = 0;
                }
            }

            for (int i = 1;i <= n;i ++) {
                for (int j = 0;j <= m;j ++) {
                    if (j < Vol[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - Vol[i]] + Val[i]);
                    }
                }
            }


            System.out.println(dp[n][m]);

        }
        in.close();
    }
}