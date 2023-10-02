package tobespring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//스프링 부트의 도움 없이 서블릿 컨테이너 개발해보기
@Configuration
@ComponentScan
public class HelloBootApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet(); //애플리케이션 컨텍스트를 스프링 컨테이너가 알아서 주입해준다.
    }

    //스프링 부트로 처음 프로젝트를 만들면 기본적으로 있는 main 메소드와 똑같이 완성 되었다.
    /*public static void main(String[] args) {
        MySpringApplication.run(HelloBootApplication.class, args);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }
}
