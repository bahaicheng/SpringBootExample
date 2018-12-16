package com.zetyun.controller;

import com.zetyun.entity.Person;
import com.zetyun.plugins.GroovyPluginExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PluginExecutorController {

    @Autowired
    GroovyPluginExecutor groovyPluginExecutor;

    @RequestMapping("/run")
    public String runPlugin(){

        try {
            testGroovyWithoutParam();
            testGroovyWithParam();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hello";
    }

    /**
     * 测试没有参数的方法调用
     */
    public void testGroovyWithoutParam() throws Exception{
        String result = (String) groovyPluginExecutor.invokeMethod("hello2.groovy", "helloWithoutParam");
        System.out.println("testGroovy4: " + result + "\n");
    }

    /**
     * 测试携带参数的方法调用
     */
    public void testGroovyWithParam()throws Exception{
        Person person = new Person("wchi", "nanjing", 30);
        String result = (String)groovyPluginExecutor.invokeMethod("hello2.groovy", "helloWithParam", person, "testGroovy4");
        System.out.println("testGroovy4: " + result + "\n");
    }
}
