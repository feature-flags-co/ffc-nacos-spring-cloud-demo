package co.featureflags.ms.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "hello-world-eng-provider")
public interface HelloWorldEngProvider {
    @GetMapping(value = "/helloworld")
    String echo();
}
