- BitMap:
    https://www.cnblogs.com/yangjiannr/p/da-shu-ju-chu-libitmap.html
- 布隆过滤器（Bloom-Filter）
        
        简介：类似于bitmap,是一种允许低错误率的场景下，大大地进行空间压缩，用错误率换空间的数据结构。
        实现：
            - 插入：插入x,x用k个hash函数对这个数进行hash,然后将这k个hash函数映射的值标记为1
            - 查询：查询x是否存在，查看k个hash函数映射的值是否全都为1，是的话则存在，否则不存在
            - 分析：存在错误率：有可能这个数不存在，但是对应的k个位置被其他数置为1，使得查询这个数存在