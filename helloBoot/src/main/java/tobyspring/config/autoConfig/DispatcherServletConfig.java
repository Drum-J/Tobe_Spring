package tobyspring.config.autoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispatcherServletConfig {
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet(); //애플리케이션 컨텍스트를 스프링 컨테이너가 알아서 주입해준다.
    }
}
