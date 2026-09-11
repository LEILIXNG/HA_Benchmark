package nw.fulfillookup;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("fulfillookupController")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/api/fulfil/lookup")
    public ResponseEntity<String> submit(HttpServletRequest request) {
        String filename = request.getHeader("X-Payment-Reference");
        LOG.debug("履约流程转下一环节");
        BundleCoordinator.resolve(filename);
        return ResponseEntity.ok("ok");
    }
}
