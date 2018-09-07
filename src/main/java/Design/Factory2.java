package Design;

/**
 * @author: xiaolong
 * @Date: 下午4:29 2018/8/25
 * @Description: 抽象工厂模式实现
 */
public class Factory2 {
    public static void main(String[] args) {
        AFoctory aFoctory = new AFoctory();
        Basee basee = aFoctory.product();
        basee.say();
    }
}

interface Basee {
    public void say();
}

class Abasee implements Basee{
    @Override
    public void say() {
        System.out.println("A");
    }
}

class Bbasee implements Basee{
    @Override
    public void say() {
        System.out.println("B");
    }
}


class AFoctory {
    public Basee product() {
        return new Abasee();
    }
}
class BFactory {
    public Basee product() {
        return new Bbasee();
    }
}