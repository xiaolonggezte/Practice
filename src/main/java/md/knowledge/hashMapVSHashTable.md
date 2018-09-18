- hashMap 和hashTable的区别
    - 继承的父类不同：
        * hashMap继承自AbstractHashMap,hashTable继承自Dictionary
        * hashTable不支持NullKey和NullValue，如果插入key==null,return NullPointerException;hashMap支持
    - 线程安全：
        * hashTable是线程安全的，因为加入了synchronize锁，但是效率不高
        * hashMap线程不安全,可以通过Collections.synchronized(hashMap)来加锁
    - 迭代器不同：
        * hashMap的迭代器有fail-fast机制，当有其他线程改变hashMap的结构的时候，将会抛出ConcurrentModificationException。
            不过，通过Iterator的remove()方法移除元素则不会抛出ConcurrentModificationException异常。
        * hashTable在JDK1.8之后才有的fail-fast机制
    - 初始容量和扩容机制不一样
        * hashTable初始11，之后每次扩容编程2*n + 1
        * hashMap初始16，之后每次扩容2*n
    - hash算法不一样
        * hashTable，用了取余方法，取余里边含有除法，所以比较耗时
            ```
                int hash = key.hashCode();
                int index = (hash & 0x7FFFFFFF) % tab.length;
            ```
        * hashTable 是用到二进制移位，
            ```
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            ```

