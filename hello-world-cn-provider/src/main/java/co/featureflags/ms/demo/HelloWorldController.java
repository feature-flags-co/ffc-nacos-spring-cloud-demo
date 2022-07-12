package co.featureflags.ms.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(value = "/helloworld")
    public String echo() {
        return "你好，世界";
    }
}
