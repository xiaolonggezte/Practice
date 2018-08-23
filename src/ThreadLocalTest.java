/**
 * @author: xiaolong
 * @Date: 上午1:19 2018/8/24
 * @Description: 如果你定义了一个单实例的java bean，它有若干属性，
 * 但是有一个属性不是线程安全的，比如说HashMap。并且碰巧你并不需要在不同的线程中共享这个属性
 * ，也就是说这个属性不存在跨线程的意义。那么你不要sychronize这么复杂的东西，ThreadLocal将是你不错的选择。
 */
import java.util.HashMap;

public class ThreadLocalTest {

    static ThreadLocal<HashMap> map0 = new ThreadLocal<HashMap>(){
        @Override
        protected HashMap initialValue() {
            System.out.println(Thread.currentThread().getName()+"initialValue");
            return new HashMap();
        }
    };
    public void run(){
        Thread[] runs = new Thread[3];
        for(int i=0;i<runs.length;i++){
            runs[i]=new Thread(new T1(i));
        }
        for(int i=0;i<runs.length;i++){
            runs[i].start();
        }
    }
    public static class T1 implements Runnable{
        int id;
        public T1(int id0){
            id = id0;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName()+":start");
            HashMap map = map0.get();
            for(int i=0;i<10;i++){
                map.put(i, i+id*100);
                try{
                    Thread.sleep(100);
                }catch(Exception ex){
                }
            }
            System.out.println(Thread.currentThread().getName()+':'+map);
        }
    }
    /**
     * Main
     * @param args
     */
    public static void main(String[] args){
        ThreadLocalTest test = new ThreadLocalTest();
        test.run();
    }

}
