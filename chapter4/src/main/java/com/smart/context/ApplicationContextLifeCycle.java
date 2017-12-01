package com.smart.context;

import com.smart.Car;
import com.smart.beanfactory.MyBeanPostProcessor;
import com.smart.beanfactory.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ApplicationContextLifeCycle {
    private static void LifeCycleInBeanFactory() {


        //①下面两句装载配置文件并启动容器
        Resource res = new ClassPathResource("com/smart/beanfactory/beans.xml");

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/smart/context/beans.xml");
        ctx.destroy();

    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
