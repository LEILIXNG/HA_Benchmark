package nw.shippingrelease;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("shippingreleaseController")
@RequestMapping("/api/shipping")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    private final ManifestFacade manifestFacade;

    public QuoteController(ManifestFacade manifestFacade) {
        this.manifestFacade = manifestFacade;
    }

    @GetMapping("/release")
    public ResponseEntity<String> prepare(HttpServletRequest request) {
        String label = request.getHeader("X-Quote-Tenant");
        LOG.debug("开始整理发运字段");
        this.manifestFacade.prepare(label);
        return ResponseEntity.ok("ok");
    }
}
