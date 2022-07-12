package co.featureflags.ms.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "hello-world-fr-provider")
public interface HelloWorldFrProvider {
    @GetMapping(value = "/helloworld")
    String echo();
}
