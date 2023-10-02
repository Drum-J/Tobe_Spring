package tobespring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

//@RestController
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name) {
        // SimpleHelloService helloService = new SimpleHelloService(); 직접 new 생성하지 않는다!
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
