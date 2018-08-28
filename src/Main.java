import java.util.Scanner;

/**
 * @author: xiaolong
 * @Date: 下午8:46 2018/8/27
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long X1 = -1000000000L,X2 = 1000000000L,Y1 = -1000000000L,Y2 = 1000000000L;
        while(in.hasNext()) {
            int n = in.nextInt();
            for(int i = 1;i <= n;i ++) {
                long x = in.nextLong();
                long y = in.nextLong();
                X1 = Math.max(X1,x);
                X2 = Math.min(X2,x);
                Y1 = Math.max(Y1,y);
                Y2 = Math.min(Y2,y);
            }
            System.out.println((X1 - X2) * (Y1 * Y2));
        }
        in.close();
    }
}
