
- http1.0 和 http1.1的区别
    
    - 提出了长连接：即多个http请求可以在一次tcp连接中不断发送
    - 支持只发送header，而不发送body。原因是先用header判断是否成功，
    再发数据，节约带宽。post请求默认
    - http1.1中的host字段。由于虚拟主机可以支持多个域名，所以一般将域名解析后得到host

- http1.0和http2.0的区别
    
    - 支持多路复用，同一个连接可以并发处理多个请求，
        方法是将http数据包拆分成多个帧，并发有序地发送，根据序号在另一端进行重组，而不需要一个个http请求顺序到达。
    - 支持服务器端推送，就是服务器端在http请求到达后，除了返回数据之外，还推送了额外的内容给客户端。
    - 压缩了请求头，同时基本单位是二进制帧流，这样的数据占用空间少
    - 2.0只是用与https场景，因为其在http和tcp之间加入了ssl层
   
   
- get VS post
    
    - 本质区别：
        * get只是一次http请求
        * post先发请求头再发请求体，实际上是两种请求
    - 表面区别：
        - get可以cache，post不能，浏览器机制
        - get幂等，post不是
        - get的参数放在url传递，而post放在请求体里，因为get没有请求体，所以get请求不安全，并且有长度限制

- https
    
    - 基础知识：
        * 对称加密：双方用同一把密匙进行加密和解密，传输密匙时如果丢失就会被破解
        * 非对称加密：双方各有一把私匙，而公匙公开。A用私匙加密，把公匙和数据传给B，然后B用公匙加密。B到A同理
        * 分析：非对称加密只要私匙不丢就很安全，但是效率比较低。
            一般方案：用 非对称加密传输对称加密的密匙，使用对称加密完成数据传输
        * 数字签名：为了防止数据在传输过程中被替换，把数据的摘要消息进行一个加密，得到一个签名，
            和数据一起发送。然后接收端收到之后把数据摘要进行加密，与数字签名进行对比。
        * 数字证书：对称加密传输中，数字签字保证用可以保证数据不被替换，但是数据是是由公匙加密的。
            防止公匙被改变，ca证书颁发一个证书，里边的证书保证是真的
    - https过程
        * 用户发送请求，服务器返回一个数字证书
        * 用户在浏览器中生成一个随机数，使用证书中的公匙进行加密，发送给服务端
        * 服务器使用公匙解密改密文，得到一个随机数
        * 往后两者使用该随机数作为公匙进行对称传输

        