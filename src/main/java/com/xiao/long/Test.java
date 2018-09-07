
public class Test{
    public static void main(String []args) {
        StringBuffer sbf = new StringBuffer("hello ");
        function(sbf);
        System.out.println(sbf);
    }

    public static void function(StringBuffer sbf) {
//        sbf = new StringBuffer("ha");
        sbf.append("World");
    }
}
