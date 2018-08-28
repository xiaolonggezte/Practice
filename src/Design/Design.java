package Design;

/**
 * @author: xiaolong
 * @Date: 下午4:20 2018/8/25
 * @Description： 静态工厂模式
 */
public class Design {
    public static void main(String[] args) {
        Base test = Factory.getAbase();
        test.say();
    }
}

interface Base {
    public void say();
}

class Abase implements Base {
    @Override
    public void say() {
        System.out.println("A");;
    }
}


class Bbase implements Base {
    @Override
    public void say() {
        System.out.println("B");
    }
}
class Factory {
    public static Abase getAbase() {
        return new Abase();
    }
    public static Bbase getBbase() {
        return new Bbase();
    }
}

