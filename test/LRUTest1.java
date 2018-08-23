import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: xiaolong
 * @Date: 下午6:44 2018/8/21
 * @Description:
 */
public class LRUTest1 {
    public static volatile int num = 1;

    public static int getNum() {
        return num;
    }

    public static void setNum() {
        LRUTest1.num ++;
    }

    public static void main(String[] args) {

        for(int i = 1;i <= 10;i ++) {
            System.out.println("Thread "+i+"th is :");
            new Thread(){
                @Override
                public void run() {
                    num ++;
                    System.out.println(num);
                }
            }.start();
        }

    }

}

class ThreadA extends Thread {
    @Override
    public void run() {
        LRUTest1.setNum();
        System.out.println(LRUTest1.getNum());
    }
}
class ThreadB extends Thread {
    @Override
    public void run() {
        LRUTest1.setNum();
        System.out.println(LRUTest1.getNum());
    }
}
