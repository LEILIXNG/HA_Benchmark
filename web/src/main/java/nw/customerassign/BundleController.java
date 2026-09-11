package nw.customerassign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("customerassignController")
@RequestMapping("/api/customer")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final PaymentRouter paymentRouter;

    public BundleController(PaymentRouter paymentRouter) {
        this.paymentRouter = paymentRouter;
    }

    @GetMapping("/assign")
    public ResponseEntity<String> submit(
            @CookieValue("bundle_session") String resource) {
        LOG.debug("客户流程转下一环节");
        this.paymentRouter.publish(resource);
        return ResponseEntity.ok("accepted");
    }
}
