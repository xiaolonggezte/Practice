import java.util.ArrayList;

/**
 * @author: xiaolong
 * @Date: 上午12:28 2018/8/24
 * @Description:实现生产者消费者问题
 */
public class ProductAndConsumer {
    private int Maxsize;
    private ArrayList<String> list;

    public ProductAndConsumer(int maxsize, ArrayList<String> list) {
        Maxsize = maxsize;
        this.list = list;
    }
    public void produce() {
        try {
            synchronized(list){
                while(list.size() == Maxsize) {
                    System.out.println("不能生产");
                    list.wait();
                }
                list.add("添加一个生产任务");
                System.out.println(Thread.currentThread().getName() + "生产任务" + list.size());
                Thread.sleep(1000);
                list.notify();
            }
        } catch(Exception e) {

        }
    }
    public String consumer() {
        try {
            synchronized(list){
                while(list.size() == 0) {
                    System.out.println("不能消费");
                    list.wait();
                }
                String consume = list.remove(list.size() - 1);
                System.out.println(Thread.currentThread().getName() + "消费" + list.size());
                Thread.sleep(1000);
                list.notify();
                return consume;
            }
        } catch (Exception e) {

        }
        return null;
    }
    public static void main(String []args) {
        ArrayList<String> list = new ArrayList<>();
        ProductAndConsumer productAndConsumer = new ProductAndConsumer(100,list);
        for(int i = 1;i <= 5;i ++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    productAndConsumer.produce();
                }
            }).start();
        }
        for(int i = 1;i <= 5;i ++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    productAndConsumer.consumer();
                }
            }).start();;
        }
    }
}
