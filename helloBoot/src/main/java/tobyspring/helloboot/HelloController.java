package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        // SimpleHelloService helloService = new SimpleHelloService(); 직접 new 생성하지 않는다!
        if (name == null || name.length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }
}
