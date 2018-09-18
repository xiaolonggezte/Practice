import java.io.IOException;

/**
 * @author: xiaolong
 * @Date: 上午1:50 2018/9/10
 * @Description: 测试try,catch,finally的用法
 *
 */
public class TestTryCatchFinal {

    public static String func() {
        try {
            System.out.println("do");
            throw new IOException();
        } catch (Exception e) {
            System.out.println("catch");
            return "CatchReact";
        } finally {
            System.out.println("final");
//            return "finalReact";
        }
    }
    public static void main(String[] args) {
        System.out.println(func());
    }
}
/**
 * @result:
 * do
 * catch
 * final
 * CatchReact
 * @inclusion:
 * 如果有finally，先执行完finally，然后return
 * finally中的return具有先执行权，相比于catch
 */