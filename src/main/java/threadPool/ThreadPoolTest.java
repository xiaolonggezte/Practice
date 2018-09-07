package threadPool;

import java.util.concurrent.*;

/**
 * @author: xiaolong
 * @Date: 上午12:06 2018/9/6
 * @Description: Executor 四种线程池的测试
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        cacheThreadpoolTest();
        fixedThreadPoolTest();
        scheduledThreadPoolTest();
        singleThreadPoolTest();

    }

    /**
     * (1). newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     * result:
     * 发现10个线程都是使用的线程1，线程池为无限大，当执行第二个任务时第一个任务已经完成，
     * 会复用执行第一个任务的线程，而不用每次新建线程
     */
    public static void cacheThreadpoolTest() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 0;i < 10;i ++) {
            final int index = i;
            try {
                Thread.sleep(i * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("Cache :" + index + "当前线程为：" + Thread.currentThread().getName());
                }
            });
        }
        cachedThreadPool.shutdown();
    }

    /**
     *  (2). newFixedThreadPool
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     * result:
     * 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字
     *
     * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
     */
    public static void fixedThreadPoolTest() {
        ExecutorService fixThreadPool = Executors.newFixedThreadPool(3);
        for(int i = 0;i < 10;i ++) {
            final int index = i;
            fixThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("Fix :" + index + "当前线程为:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        fixThreadPool.shutdown();
    }

    /**
     * (3) newScheduledThreadPool
     * 创建一个定长线程池，支持定时及周期性任务执行
     */
    public static void scheduledThreadPoolTest() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("Scheduled: delay 3 seconds " + Thread.currentThread().getName());
            }
        },1,3,TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();
    }

    /**
     * (4)、newSingleThreadExecutor
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */
    public static void singleThreadPoolTest() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for(int i = 0;i < 10;i ++) {
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("当前线程：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        singleThreadPool.shutdown();
    }
}
