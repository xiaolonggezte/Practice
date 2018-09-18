- Git中reset和revert的区别
https://www.cnblogs.com/houpeiyong/p/5890748.html
- 它俩都是进行代码回滚的命令
    * reset 直接跳到一个历史版本上
        * --soft 缓存区和工作目录都不会被更改
        * --mixed 默认选项，缓存区和指定的提交同步，但不会影响工作目录
        * --hard 缓存区和工作目录都同步到你指定的提交
    * revert 创建一个新的版本，然后指向它