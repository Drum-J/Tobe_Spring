package tobespring.helloboot;

//@RestController
public class HelloController {

    //@GetMapping("/hello")
    public String hello(String name) {
        return "Hello " + name;
    }
}
