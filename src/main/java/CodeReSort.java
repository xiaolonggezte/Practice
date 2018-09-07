/**
 * @author: xiaolong
 * @Date: 下午8:09 2018/8/31
 * @Description: 指令重排序测试实践学习
 */
public class CodeReSort {
    public static int x = 0,y = 0;
    public static void main(String[] args) throws Exception {
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 1000;i ++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 1000;i ++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        one.start();
        two.start();
//        one.join();
//        /**
//         * join的意思是使得放弃当前线程的执行，并返回对应的线程，直至对应的线程运行完，然后返回到之前运行的线程。
//         */
//        two.join();
//        System.out.println(x + " " + y);
    }
}
