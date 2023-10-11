package tobyspring.helloboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspring.config.MySpringBootApplication;

//스프링 부트의 도움 없이 서블릿 컨테이너 개발해보기
@MySpringBootApplication
public class HelloBootApplication {

    //스프링 부트로 처음 프로젝트를 만들면 기본적으로 있는 main 메소드와 똑같이 완성 되었다.
    /*public static void main(String[] args) {
        MySpringApplication.run(HelloBootApplication.class, args);
    }*/


   /* @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name = " + name);
        };
    }*/
    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }
}
