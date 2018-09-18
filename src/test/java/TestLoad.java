import java.util.HashMap;

/**
 * @author: xiaolong
 * @Date: 上午2:04 2018/9/10
 * @Description:
 */
public class TestLoad extends A {

    static {
        System.out.println("B static Block");
    }

    public static void main(String[] args) {
        System.out.println(n);
    }
}

class A {
    static {
        System.out.println("A static block");
    }
    public static final int n = 10;
}