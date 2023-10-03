package tobespring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

//HelloController Unit Test
public class HelloControllerTest {
    @Test
    void helloControllerTest() {
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test Controller");

        assertThat(ret).isEqualTo("Test Controller");
    }

    @Test
    void failsHelloController() {
        HelloController helloController = new HelloController(name -> name);

        assertThatThrownBy(() -> {
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
