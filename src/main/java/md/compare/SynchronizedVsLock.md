
- 锁类型
    * 可重入锁：在执行对象中的所有同步方法不能再次获得锁
    * 可中断锁：在等待获取锁的过程中可中断
    * 公平锁：按照等待时间长短来获取锁
    * 读写锁：读写分离，读多线程读，写的话只能同步地写
   
- 由于synchronized是在jvm层面实现的，所以系统可以在系统中监控锁的释放与否；
    而ReentranctLock是在代码层面实现的，所以要在finally中显示释放lock.unlock();
    https://blog.csdn.net/u012403290/article/details/64910926?locationNum=11&fps=1
   举的两个例子讲的不错
- 选择：少量并发：synchronize；大量并发：lock

- https://blog.csdn.net/u012403290/article/details/64910926?locationNum=11&fps=1
- 区别：
    * 层次：synchronize在jvm层面；Lock是一个类
    * 锁的释放：前者jvm释放；后者在finally中代码释放unlock
    * 锁获取：前者一直要等待获取锁的线程释放锁；Lock有多个获取锁的方式
    * 锁状态：lock可以判断锁的状态，synchronize不能
    * 锁类型：synchronize是可重入锁，不可中断锁，非公平的锁；
            lock是可重入，可判断，可公平；默认为非公平
    * 性能：前者少量同步；后者大量同步
    
            