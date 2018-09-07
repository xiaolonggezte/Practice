package project.demo;

import project.service.TestService;
import project.service.impl.TestServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: xiaolong
 * @Date: 下午9:51 2018/8/31
 * @Description: JDK 动态代理
 */
public class JDKDynamicProxy  implements InvocationHandler {
    private Object proxyObj;


    public Object newProxy(Object proxyObj) {
        this.proxyObj = proxyObj;
        /**
         * Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
         * loader    :类加载器 一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
         * interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
         * h         :一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
         */
        //返回代理对象
        return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(),proxyObj.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforce();
        Object object = method.invoke(this.proxyObj,args);
        after();
        return object;

    }
    public void beforce() {
        System.out.println("before");
    }
    public void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        TestService testService = new TestServiceImpl();
//        testService.add();//不是用代理
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        TestService testServiceProxy = (TestService) jdkDynamicProxy.newProxy(testService);
        testServiceProxy.add();
    }
}
