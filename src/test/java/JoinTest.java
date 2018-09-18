import java.io.IOException;

/**
 * @author: xiaolong
 * @Date: 下午6:15 2018/9/6
 * @Description:
 */
public class JoinTest {


    public static String func() {
        try {
            System.out.println("do");
            throw new IOException();
        } catch (Exception e) {
            System.out.println("catch");
            return "Yes";
        } finally {
            System.out.println("final");
        }
    }
    public static void main(String[] args) {
        System.out.println(func());
    }
}
