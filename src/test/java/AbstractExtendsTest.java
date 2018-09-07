/**
 * @author: xiaolong
 * @Date: 下午6:00 2018/9/6
 * @Description:
 */
public class AbstractExtendsTest extends AbstructTest{

    public void justAbstract() {
        System.out.println("Test justAbstract");
    }

    public static void main(String[] args) {
        AbstractExtendsTest abstractExtendsTest = new AbstractExtendsTest();
        abstractExtendsTest.justAbstract();
        abstractExtendsTest.justTest();
    }
}
