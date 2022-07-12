package co.featureflags.ms.demo;

import co.featureflags.commons.model.FFCUser;
import co.featureflags.server.exterior.FFCClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final FFCClient client;

    private final HelloWorldCnProvider cnProvider;

    private final HelloWorldEngProvider engProvider;

    private final HelloWorldFrProvider frProvider;

    @GetMapping(value = "/helloworld")
    public String echo(@RequestHeader(value = "x-user-key") String userKey,
                       @RequestHeader(value = "x-user-name") String userName) {
        var user = new FFCUser.Builder(userKey).userName(userName).build();
        var res = client.variation("featureA", user, null);
        if ("cn".equals(res)) {
            return cnProvider.echo();
        } else if ("eng".equals(res)) {
            return engProvider.echo();
        } else if ("fr".equals(res)) {
            return frProvider.echo();
        } else {
            return "Not Support Lang";
        }
    }
}
