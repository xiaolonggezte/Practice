/**
 * @author: xiaolong
 * @Date: 下午2:22 2018/8/26
 * @Description:
 */
public class facewrite {

    /**
     *
     * 线程池的几个参数
     * corePoolSize：线程池的基本大小。下面会解释什么是基本大小
     * maximumPoolSize：线程池中允许的最大线程数。
     * 注意还有一个largestPoolSize，记录了曾经出现的最大线程个数。因为setMaximumPoolSize()可以改变最大线程数。
     * poolSize：线程池中当前线程的数量。
     *
     * 那么poolSize、corePoolSize、maximumPoolSize三者的关系是如何的呢？
     * 当新提交一个任务时：
     * （1）如果poolSize<corePoolSize，新增加一个线程处理新的任务。
     * （2）如果poolSize=corePoolSize，新任务会被放入阻塞队列等待。
     * （3）如果阻塞队列的容量达到上限，且这时poolSize<maximumPoolSize，新增线程来处理任务。
     * （4）如果阻塞队列满了，且poolSize=maximumPoolSize，那么线程池已经达到极限，会根据饱和策略RejectedExecutionHandler拒绝新的任务。
     *
     *
     *
     *
     *
     *
     */
}
