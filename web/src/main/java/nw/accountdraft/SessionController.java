package nw.accountdraft;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("accountdraftController")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final AccountRouter accountRouter;

    public SessionController(AccountRouter accountRouter) {
        this.accountRouter = accountRouter;
    }

    @GetMapping("/api/account/draft")
    public String assemble(HttpServletRequest request) {
        String resource = request.getHeader("X-Session-Tenant");
        LOG.debug("接收到一次账户处理请求");
        this.accountRouter.normalize(resource);
        return "ok";
    }
}
