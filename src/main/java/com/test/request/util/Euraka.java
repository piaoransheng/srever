package com.test.request.util;

import com.test.request.annotation.RpcClazz;
import com.test.request.annotation.RpcMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class Euraka {
    public static void main(String[] args) throws Exception {
        Map<String,String> resultMap= new HashMap<>();
        Set<Class<?>> classes = ClassUtil.getClasses("com.test.web.dao");  //1.获取所有的类
        if (!classes.isEmpty()){
            for (Class clazz:classes){
                Annotation clazzDeclaredAnnotation = clazz.getDeclaredAnnotation(RpcClazz.class);
                if (clazzDeclaredAnnotation != null){   //2.类上有指定注解
                    Method[] declaredMethods = clazz.getDeclaredMethods();
                    for (Method method:declaredMethods){
                        //获取当前类有注解的方法
                        RpcMethod methodDeclaredAnnotation = method.getDeclaredAnnotation(RpcMethod.class);
                        if (methodDeclaredAnnotation != null){   //3.方法上有指定注解
                            resultMap.put(clazz.getSimpleName() + method.getName(),method.getName());
                        }
                    }
                }
            }
        }
    }
}