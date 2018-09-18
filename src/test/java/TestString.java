/**
 * @author: xiaolong
 * @Date: 上午1:55 2018/9/10
 * @Description: 测试string的相等相关
 */
public class TestString {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = new String("abc");
        System.out.println("a == b ? : " + (a == b) );
        System.out.println("a == c ? : " + (a == c) );
        System.out.println("c == d ? : " + (c == d));
        System.out.println("c euqals d ? : " + (c.equals(d)));
    }
}
