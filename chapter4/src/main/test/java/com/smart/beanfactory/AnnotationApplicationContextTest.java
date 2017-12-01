package com.smart.beanfactory;

import com.smart.Car;
import com.smart.context.Beans;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class AnnotationApplicationContextTest {

    @Test
    public void getBean() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car", Car.class);
        Assert.notNull(car);
    }
}
