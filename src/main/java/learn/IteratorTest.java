package learn;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author: xiaolong
 * @Date: 上午10:36 2018/9/3
 * @Description: 测试时间Iterator方法
 */

public class IteratorTest implements Iterable<String> {

    public String[] words = "I have a dream,I would be a successful man".split(" ");
    public static void main(String[] args) {
        HashMap<String ,String> map = new HashMap<String,String>();
        IteratorTest test = new IteratorTest();
        for(String s : test) {
            System.out.println(s);
        }

    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index ++];
            }
        };
    }


}
