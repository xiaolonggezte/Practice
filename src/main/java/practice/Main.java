package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: xiaolong
 * @Date: 上午11:40 2018/9/1
 * @Description:
 */
public class Main {
    public static final int maxn = 100000 + 10;
    public static int[] a = new int[maxn];
    Set setTest = new HashSet<String>(){{
        add("a");
        add("b");
    }};
    public static void main(String[] args) {
        Main mainA = new Main();
        System.out.println(mainA.setTest.contains("a"));
    }
}
