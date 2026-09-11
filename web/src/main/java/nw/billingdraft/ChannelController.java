package nw.billingdraft;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账务场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("billingdraftController")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final QuoteFacade quoteFacade;

    public ChannelController(QuoteFacade quoteFacade) {
        this.quoteFacade = quoteFacade;
    }

    @GetMapping("/api/billing/draft")
    public ResponseEntity<String> dispatch(HttpServletRequest request) {
        String query = request.getHeader("X-Channel-Context");
        LOG.trace("进入账务处理环节");
        this.quoteFacade.submit(query);
        return ResponseEntity.ok("ok");
    }
}
