package com.template.demo;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ResourceBundle;

public class DemoAppCoreJava {

    /**
     * HelloWorld entry point for application.
     *
     * @param args arguments passed into application at runtime
     */
    public static void main(final String... args) {
        DemoAppCoreJava hw = new DemoAppCoreJava();
        hw.display(hw.helloWorld());

        ResourceBundle rb = ResourceBundle.getBundle("application");

        String port = System.getenv("port") == null ? rb.getString("port") : System.getenv("port");
        final String greetingMessage = rb.getString("server.greetingMessage");
        String servletName = rb.getString("server.servletName");
        String servletContext =  System.getenv("context");
        

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(Integer.parseInt(port));

        Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());

        Tomcat.addServlet(ctx, servletName, new HttpServlet() {
            protected void service(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                Writer w = resp.getWriter();
                w.write(greetingMessage);
                w.flush();
            }
        });
        
        if(servletContext != null && !servletContext.isEmpty()){
             ctx.addServletMappingDecoded(servletContext+"/*",servletName);
         }else {
            ctx.addServletMappingDecoded("/*",servletName);
        }
        

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            System.out.println("Exception occur:" + e.getMessage());
        }
        tomcat.getServer().await();

    }

    /**
     * Returns hello world.
     *
     * @return The String, "Hello, World!"
     */
    public final String helloWorld() {
        return "Hello, World! <Java 17 Maven>";
    }

    /**
     * Displays the given message to System.out.
     *
     * @param display The message to display
     */
    public final void display(String display) {
        System.out.println(display);
    }
}
