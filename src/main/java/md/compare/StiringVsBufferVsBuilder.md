- String VS StringBuffer VS StringBuilder

- 三者都是final进行修饰，String是字符串常量，StringBuffer和StringBuilder都是字符串变量，因为String中的char数组用final进行修饰了
- 速度对比：String < StringBuffer < StringBuilder，
    因为StringBuffer为了保证线程安全，对操作进行加sychronized锁，而String常量，所以改变的时候都是在新建另一个常量字符串，然后销毁原来的字符串