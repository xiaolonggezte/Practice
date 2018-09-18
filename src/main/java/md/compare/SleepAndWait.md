## sleep 和 wait的不同

* sleep 方法是Thread的静态方式；wait是对象Object的方法
* sleep 不会释放锁，也不会占用锁。wait方法会释放锁，但调用他的前提是当前线程占有锁（即代码要放在synchronized中）
* sleep 要处理异常；wait，notify和notifyAl只能在同步控制方法或者同步控制块里面使用
* Thread.sleep(0) 触发操作系统立即重新进行一次CPU竞争
* wait()可以设置一个超时时间，即在wait()函数中加入参数，如：
    wait(1000)表示将锁释放1000毫秒，到时间后如果锁没有被其他线程占用，
    则再次得到锁，然后wait方法结束，执行后面的代码，如果锁被其他线程占用，
    则等待其他线程释放锁。注意，设置了超时时间的wait方法一旦过了超时时间，
    并不需要其他线程执行notify也能自动解除阻塞，
    但是如果没设置超时时间的wait方法必须等待其他线程执行notify

* 都可以被interrupted方法中断    
