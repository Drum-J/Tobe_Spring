package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//SimpleHelloTest Unit Test
/*@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest{

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Test
@interface UnitTest{

}*/
public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        String ret = simpleHelloService.sayHello("Spring");

        assertThat(ret).isEqualTo("Hello Spring");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String test = decorator.sayHello("Test");

        assertThat(test).isEqualTo("*Test*");
    }
}
