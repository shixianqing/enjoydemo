package com.example.annotations.beanpostprocessor; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* BeanPostProcessorConfig Tester. 
* 
* @author <Authors name> 
* @version 1.0 
*/ 
public class BeanPostProcessorConfigTest { 

    @Before
    public void before() throws Exception { 
    
    } 
    
    @After
    public void after() throws Exception { 
    
    } 
    
        /** 
    * 
    * Method: cat() 
    * 
    */ 
    @Test
    public void testCat() throws Exception {

        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);

    } 
    
        
}
