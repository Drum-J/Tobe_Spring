package tobespring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//스프링 부트의 도움 없이 서블릿 컨테이너 개발해보기
public class HelloBootApplication {

    public static void main(String[] args) {
        //스프링 컨테이너 사용하기
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(HelloController.class); //빈 등록 완료
        applicationContext.registerBean(SimpleHelloService.class); //빈 등록 완료
        applicationContext.refresh();//빈 오브젝트 생성

        //톰캣(server) 띄우기
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {

            servletContext.addServlet("dispatcherServlet",
                    new DispatcherServlet(applicationContext) //dispatcherServlet  사용
            ).addMapping("/*");

        });
        webServer.start();
    }

}
