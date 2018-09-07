package threadPool;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author: xiaolong
 * @Date: 上午1:07 2018/9/6
 * @Description: ThreadPoolExecutor的构造方法的几个参数
 *
 *
 * 参考：https://www.cnblogs.com/guweiwei/p/6559408.html
 */
public class ThreadPoolExecutorTest {
    /**
     *
     * 构造方法：
     * public ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue,
     *                               ThreadFactory threadFactory,
     *                               RejectedExecutionHandler handler) {
     *         if (corePoolSize < 0 ||
     *             maximumPoolSize <= 0 ||
     *             maximumPoolSize < corePoolSize ||
     *             keepAliveTime < 0)
     *             throw new IllegalArgumentException();
     *         if (workQueue == null || threadFactory == null || handler == null)
     *             throw new NullPointerException();
     *         this.corePoolSize = corePoolSize;
     *         this.maximumPoolSize = maximumPoolSize;
     *         this.workQueue = workQueue;
     *         this.keepAliveTime = unit.toNanos(keepAliveTime);
     *         this.threadFactory = threadFactory;
     *         this.handler = handler;
     *     }
     */


    /**
     *
     * 1）当池子大小小于corePoolSize就新建线程，并处理请求
     *
     * 2）当池子大小等于corePoolSize，把请求放入workQueue中，池子里的空闲线程就去从workQueue中取任务并处理
     *
     * 3）当workQueue放不下新入的任务时，新建线程入池，并处理请求，如果池子大小撑到了maximumPoolSize就用RejectedExecutionHandler来做拒绝处理
     *
     * 4）另外，当池子的线程数大于corePoolSize的时候，多余的线程会等待keepAliveTime长的时间，如果无请求可处理就自行销毁
     * @param args
     */
    public static void main(String[] args) {

    }
}
