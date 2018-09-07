package project.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: xiaolong
 * @Date: 下午11:03 2018/8/31
 * @Description: CGLIB 实现动态代理
 */
public class DGLIBProxy implements MethodInterceptor {
    private Object object;
//    public Object createProxyObject(Object object) {
//        this.object = object;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(object.getClass());//设置代理目标
//        enhancer.setCallback(this);//设置回调
//        return enhancer.create();
//    }
//
//
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//        try {
//            System.out.println("前置处理");
////            result
//            System.out.println("后置处理");
//
//        } catch(Exception e) {
//            System.out.println("异常处理");
//        } finally {
//            System.out.println("调用结束");
//        }
        return null;
    }
}
