package com.test.request;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws Exception {
        publishServer();
    }

    /*创建服务端并接受连接请求*/
    public static void publishServer() throws  Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService executorService = Executors.newFixedThreadPool(5);  //并发编程执行器
        while (true) {
            System.out.println("服务端等待连接......");
            Socket accept = serverSocket.accept();
            System.out.println("服务端连接成功......");
            executorService.execute(new ServerHandler(accept));  //并发编程执行器 执行线程
        }
    }
}
