package com.test.web.dao;

import com.test.request.annotation.RpcClazz;
import com.test.request.annotation.RpcMethod;

@RpcClazz
public class OrderDao {
    @RpcMethod
    public void server1(String name){
        System.out.println("服务端的server方法执行了");
        System.out.println("方法参数name是：" + name);
    }

    @RpcMethod
    public void server2(String name){
        System.out.println("服务端的server方法执行了");
        System.out.println("方法参数name是：" + name);
    }
}
