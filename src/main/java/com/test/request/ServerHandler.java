package com.test.request;


import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/*处理客户端的请求*/
public class ServerHandler implements Runnable {
    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    /*调用 OrderDao.serve*/
    @Override
    public void run()  {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcInfo rpcInfo = (RpcInfo) objectInputStream.readObject();
            Class<?> clazz = Class.forName(rpcInfo.getPackageName() + "." + rpcInfo.getClazzName());  //利用反射创建类：UserDao
            Class[] classes = new Class[rpcInfo.getArgs().length];  //classes是serve这个方法所有的参数类型（从客户端传过来）
            for (int i = 0 ;i<classes.length;i++){
                classes[i] = rpcInfo.getArgs()[i].getClass();
            }
            Method method = clazz.getMethod(rpcInfo.getMethodName(), classes);
            method.invoke(clazz.newInstance(),rpcInfo.getArgs());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
