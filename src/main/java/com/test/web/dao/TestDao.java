package com.test.web.dao;

import com.test.request.annotation.RpcClazz;
import com.test.request.annotation.RpcMethod;

@RpcClazz
public class TestDao {
    @RpcMethod
    public void test1(String name){
        System.out.println("服务端的test方法执行了");
        System.out.println("方法参数name是：" + name);
    }


    @RpcMethod
    public void test3(String name){
        System.out.println("服务端的test方法执行了");
        System.out.println("方法参数name是：" + name);
    }
}
