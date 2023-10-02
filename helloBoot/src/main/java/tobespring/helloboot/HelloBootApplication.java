package tobespring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//스프링 부트의 도움 없이 서블릿 컨테이너 개발해보기
//@SpringBootApplication
public class HelloBootApplication {

    public static void main(String[] args) {
        //SpringApplication.run(HelloBootApplication.class, args);

        //톰캣(server) 띄우기
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();

            servletContext.addServlet("frontcontroller", new HttpServlet() { // 프론트 컨트롤러로 전환
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증, 보안, 다국어, 공통 기능

                    // Get 메소드로 /hello 를 접근하면 실행
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        String name = req.getParameter("name"); //파라미터 받기

                        String ret = helloController.hello(name); // helloController 사용

                        //enum 활용해서 하드코딩 피하기
                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);

                    } else if (req.getRequestURI().equals("/user")) {
                        // 유저
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }

                }
            }).addMapping("/*");

        });
        webServer.start();
    }

}
