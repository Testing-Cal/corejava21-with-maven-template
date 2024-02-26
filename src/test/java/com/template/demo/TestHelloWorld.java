package com.template.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*Test*/
public class TestHelloWorld {

    @Test
    public void testHelloWorld() {
        DemoAppCoreJava demoHelloWorld = new DemoAppCoreJava();
        assertEquals(demoHelloWorld.helloWorld(), "Hello, World! <Java 17 Maven>");
    }
}
