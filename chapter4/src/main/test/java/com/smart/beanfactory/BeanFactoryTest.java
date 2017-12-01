package com.smart.beanfactory;

import com.smart.Car;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created by zhangcheng on 2017/12/1 10:24.
 */
public class BeanFactoryTest {

    @Test
    public void getBean() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:com/smart/beanfactory/beans.xml");

        System.out.println(res.getURI());
        System.out.println(res.getURL());

        //被废弃
        //XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(res);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(res);

        System.out.println("init BeanFactory!");

        Car car = beanFactory.getBean("car", Car.class);
        System.out.println("car bean is ready for use!");
        car.introduce();

        beanFactory.destroySingletons();

    }

}
