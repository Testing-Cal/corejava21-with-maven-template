package com.template.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*Test*/
public class TestHelloWorld {

    @Test
    public void testHelloWorld() {
        DemoAppCoreJava demoHelloWorld = new DemoAppCoreJava();
        assertEquals(demoHelloWorld.helloWorld(), "Hello, World! <Java 17 Maven>");
    }
}
