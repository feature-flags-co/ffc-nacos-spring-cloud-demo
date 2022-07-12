package co.featureflags.ms.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "hello-world-cn-provider")
public interface HelloWorldCnProvider {
    @GetMapping(value = "/helloworld")
    String echo();
}
