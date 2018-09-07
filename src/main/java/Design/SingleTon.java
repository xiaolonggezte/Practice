package Design;

/**
 * @author: xiaolong
 * @Date: 下午4:37 2018/8/25
 * @Description: 单例模式
 */

/**
 * 懒汉
 */
public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    private SingleTon() {

    }
    public static SingleTon getInstance() {
        return singleTon;
    }
}

/**
 * 饿汉
 */
class SingleTon2 {
    private static SingleTon2 singleTon2 = null;
    private SingleTon2() {

    }
    public static synchronized SingleTon2 getInstance() {
        if(singleTon2 == null) {
            singleTon2 = new SingleTon2();
        }
        return singleTon2;
    }
}

/**
 * 双重检查
 */
class SingleTon3 {
    private static SingleTon3 singleTon3 = null;
    private SingleTon3() {

    }
    public static  SingleTon3 getInstance() {
        if(singleTon3 == null) {
            synchronized(singleTon3) {
                if(singleTon3 == null) {
                    singleTon3 = new SingleTon3();
                }
            }
        }
        return singleTon3;
    }
}

class SingleTon33 {
    private static SingleTon33 singleTon33 = null;
    private SingleTon33() {

    }
    public static  SingleTon33 getInstance() {
        if(singleTon33 == null) {
            synchronized(singleTon33) {
                if(singleTon33 == null) {
                    singleTon33 = new SingleTon33();
                }
            }
        }
        return singleTon33;
    }
}

/**
 * 实际情况是，单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候
 * ，这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。
 * 同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。这样我们暂时总结一个完美的单例模式：
 */
class SingleTon4 {
    private SingleTon4() {

    }
    public static class SingleFactory {
        public static SingleTon4 singleTon4 = new SingleTon4();
    }
    public static SingleTon4 getInstance() {
        return SingleFactory.singleTon4;
    }
}
