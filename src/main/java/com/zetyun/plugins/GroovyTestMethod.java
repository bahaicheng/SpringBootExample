package com.zetyun.plugins;


import com.zetyun.entity.Person;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GroovyTestMethod {

    public static void main(String[] args) throws Exception {
        queueGroovyWithParam();
    }

    /**
     * 测试携带参数的方法调用
     */
    public static void queueGroovyWithParam() throws Exception {
        GroovyPluginExecutor groovyPluginExecutor = new GroovyPluginExecutor();
        BlockingQueue queue = new LinkedBlockingQueue();
        new Thread(new QueueReader(queue)).start();
        BlockingQueue queueResult = (BlockingQueue) groovyPluginExecutor.invokeMethod("hello2.groovy", "queue", queue, "testqueue");
        System.out.println("queueGroovyWithParam: " + queueResult + "\n");
    }


    /**
     * 测试没有参数的方法调用
     */
    public static void testGroovyWithoutParam() throws Exception {
        GroovyPluginExecutor groovyPluginExecutor = new GroovyPluginExecutor();
        String result = (String) groovyPluginExecutor.invokeMethod("hello2.groovy", "helloWithoutParam");
        System.out.println("testGroovy4: " + result + "\n");
    }

    /**
     * 测试携带参数的方法调用
     */
    public static void testGroovyWithParam() throws Exception {
        GroovyPluginExecutor groovyPluginExecutor = new GroovyPluginExecutor();
        Person person = new Person("wchi", "nanjing", 30);
        String result = (String) groovyPluginExecutor.invokeMethod("hello2.groovy", "helloWithParam", person, "testGroovy4");
        System.out.println("testGroovy4: " + result + "\n");
    }

}
