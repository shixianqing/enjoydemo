package com.example.aop; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* AspectConfig Tester. 
* 
* @author <Authors name> 
* @version 1.0 
*/ 
public class AspectConfigTest { 

    @Before
    public void before() throws Exception { 
    
    } 
    
    @After
    public void after() throws Exception { 
    
    } 
    
        /** 
    * 
    * Method: calculate() 
    * 
    */ 
    @Test
    public void testCalculate() throws Exception {

        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AspectConfig.class);

        Calculate calculate = app.getBean(Calculate.class);
        int result = calculate.div(4, 0);
        System.out.println(result);
    } 
    
        
    } 
