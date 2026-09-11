package nw.fulfilintake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfilintakeController")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final BundleCoordinator bundleCoordinator;

    public SessionController(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    @GetMapping("/api/fulfil/intake")
    public String merge(
            @RequestParam("reference") String reference) {
        LOG.debug("接收到一次履约处理请求");
        this.bundleCoordinator.register(reference);
        return "ok";
    }
}
