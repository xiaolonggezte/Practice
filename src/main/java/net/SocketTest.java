package net;


import java.io.*;
import java.net.*;

/**
 * @author: xiaolong
 * @Date: 下午10:59 2018/9/17
 * @Description: Socket编程测试
 * https://www.cnblogs.com/rocomp/p/4790340.html
 *
 * IP地址+端口号组成了所谓的Socket，Socket是网络上运行的程序之间双向通信链路的终结点，是TCP和UDP的基础
 * Socket套接字：
 * 网络上具有唯一标识的IP地址和端口组合在一起才能构成唯一能识别的标识符套接字。
 * Socket原理机制：
 *     通信的两端都有Socket
 *     网络通信其实就是Socket间的通信
 *     数据在两个Socket间通过IO传输
 *
 * Java中的网络支持：
 *              针对网络通信的不同层次，Java提供了不同的API，其提供的网络功能有四大类：
 *               1. InetAddress:用于标识网络上的硬件资源，主要是IP地址
 *               2. URL：统一资源定位符，通过URL可以直接读取或写入网络上的数据
 *               3. Sockets：使用TCP协议实现的网络通信Socket相关的类
 *               4. Datagram:使用UDP协议，将数据保存在用户数据报中，通过网络进行通信
 *
 */

//TODO 进阶https://www.cnblogs.com/yiwangzhibujian/p/7107785.html
public class SocketTest {
    public static void main(String[] args) throws IOException {
//        inetAdressTest();
//        URLTest();
        TCPTest();
//        UDPTest();
    }

    /**
     *
     * 1. InetAddress类用于标识网络上的硬件资源，标识互联网协议(IP)地址。
     *
     * @throws UnknownHostException
     */
    public static void inetAdressTest() throws UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName() + " " + address.getHostAddress());

    }

    /**
     * 2. URL
     * @throws IOException
     */
    public static void URLTest() throws IOException {
        /**
         * 2.1 URL(Uniform Resource Locator)统一资源定位符，表示Internet上某一资源的地址，协议名：资源名称
         */
        URL baidu = new URL("http://www.baidu.com");
        URL url = new URL(baidu,"/index.html?username=tom#test");

        url.getProtocol();//获取协议
        url.getHost();//获取主机
        url.getPort();//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
        url.getPath();//获取文件路径
        url.getFile();//文件名，包括文件路径+参数
        url.getRef();//相对路径，就是锚点，即#号后面的内容
        url.getQuery();//查询字符串，即参数

        /**
         * 2.2 使用URL读取网页内容
         */
        //创建一个URL实例
        URL url2 =new URL("http://www.baidu.com");
        InputStream is = url2.openStream();//通过openStream方法获取资源的字节输入流
        InputStreamReader isr =new InputStreamReader(is,"UTF-8");//将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
        BufferedReader br = new BufferedReader(isr);//为字符输入流添加缓冲，提高读取效率
        String data = br.readLine();//读取数据
        while(data!=null){
            System.out.println(data);//输出数据
            data = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
    }

    /**
     * TCP编程
     *          1、TCP协议是面向连接的、可靠的、有序的、以字节流的方式发送数据，通过三次握手方式建立连接，形成传输数据的通道，在连接中进行大量数据的传输，效率会稍低
     *          2、Java中基于TCP协议实现网络通信的类
     *             客户端的Socket类
     *             服务器端的ServerSocket类
     *
     *             3、Socket通信的步骤
     *                  ① 创建ServerSocket和Socket
     *                  ② 打开连接到Socket的输入/输出流
     *                  ③ 按照协议对Socket进行读/写操作
     *                  ④ 关闭输入输出流、关闭Socket
     *            4、服务器端：
     *                  ① 创建ServerSocket对象，绑定监听端口
     *                  ② 通过accept()方法监听客户端请求
     *                  ③ 连接建立后，通过输入流读取客户端发送的请求信息
     *                  ④ 通过输出流向客户端发送乡音信息
     *                  ⑤ 关闭相关资源
     *            5、客户端：
     *
     *                  ① 创建Socket对象，指明需要连接的服务器的地址和端口号
     *                  ② 连接建立后，通过输出流想服务器端发送请求信息
     *                  ③ 通过输入流获取服务器响应的信息
     *                  ④ 关闭响应资源
     *            6、应用多线程实现服务器与多客户端之间的通信
     *
     *                ① 服务器端创建ServerSocket，循环调用accept()等待客户端连接
     *                ② 客户端创建一个socket并请求和服务器端连接
     *                ③ 服务器端接受苦读段请求，创建socket与该客户建立专线连接
     *                ④ 建立连接的两个socket在一个单独的线程上对话
     *                ⑤ 服务器端继续等待新的连接
     */
    public static void TCPTest() throws IOException {


        new Thread(new Runnable() {
            public void run() {
                try {
                    serverTest();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    clientTest();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * 基于TCP协议的Socket通信，实现用户登录，服务端
     */
    public static void serverTest() throws IOException {

        //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = new ServerSocket(10086);//1024-65535的某个端口
        //2、调用accept()方法开始监听，等待客户端的连接
        Socket socket = serverSocket.accept();
        //3、获取输入流，并读取客户端信息
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String info = null;
        while((info=br.readLine())!=null){
            System.out.println("我是服务器，客户端说："+info);
        }
        socket.shutdownInput();//关闭输入流
        //4、获取输出流，响应客户端的请求
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("欢迎您！");
        pw.flush();

        //5、关闭资源
        pw.close();
        os.close();
        br.close();
        isr.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

    public static void clientTest() throws IOException {
        //客户端
        //1、创建客户端Socket，指定服务器地址和端口
        Socket socket =new Socket("localhost",10086);
        //2、获取输出流，向服务器端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
        pw.write("用户名：admin；密码：123");
        pw.flush();
        socket.shutdownOutput();
        //3、获取输入流，并读取服务器端的响应信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while((info=br.readLine()) != null){
            System.out.println("我是客户端，服务器说："+info);
        }

        //4、关闭资源
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }

    /**
     *      4. UDP编程
     *        UDP协议（用户数据报协议）是无连接的、不可靠的、无序的,速度快
     *        进行数据传输时，首先将要传输的数据定义成数据报（Datagram），大小限制在64k，在数据报中指明数据索要达到的Socket（主机地址和端口号），然后再将数据报发送出去
     *        DatagramPacket类:表示数据报包
     *        DatagramSocket类：进行端到端通信的类
     *        1、服务器端实现步骤
     *            ① 创建DatagramSocket，指定端口号
     *            ② 创建DatagramPacket
     *            ③ 接受客户端发送的数据信息
     *            ④ 读取数据
    *        2、客户端实现步骤
     *
     *            ① 定义发送信息
     *            ② 创建DatagramPacket，包含将要发送的信息
     *            ③ 创建DatagramSocket
     *            ④ 发送数据
     */
    public static void UDPTest() throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    UDPServerTest();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    UDPClientTest();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public static void UDPServerTest() throws IOException {
        //服务器端，实现基于UDP的用户登录
        //1、创建服务器端DatagramSocket，指定端口
        DatagramSocket socket =new DatagramSocket(10010);
        //2、创建数据报，用于接受客户端发送的数据
        byte[] data =new byte[1024];//
        DatagramPacket packet =new DatagramPacket(data,data.length);
        //3、接受客户端发送的数据
        socket.receive(packet);//此方法在接受数据报之前会一致阻塞
        //4、读取数据
        String info =new String(data,0,data.length);
        System.out.println("我是服务器，客户端告诉我"+info);


        //=========================================================
        //向客户端响应数据
        //1、定义客户端的地址、端口号、数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "欢迎您！".getBytes();
        //2、创建数据报，包含响应的数据信息
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
        //3、响应客户端
        socket.send(packet2);
        //4、关闭资源
        socket.close();
    }

    public static void UDPClientTest() throws IOException {
        //客户端
        //1、定义服务器的地址、端口号、数据
        InetAddress address =InetAddress.getByName("localhost");
        int port =10010;
        byte[] data ="用户名：admin;密码：123".getBytes();
        //2、创建数据报，包含发送的数据信息
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        //3、创建DatagramSocket对象
        DatagramSocket socket =new DatagramSocket();
        //4、向服务器发送数据
        socket.send(packet);


        //接受服务器端响应数据
        //======================================
        //1、创建数据报，用于接受服务器端响应数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
        //2、接受服务器响应的数据
//        socket.receive(packet2);
//        String reply = new String(data2,0,packet2.getLength());
//        System.out.println("我是客户端，服务器说："+reply);
        //4、关闭资源
        socket.close();
    }
}
