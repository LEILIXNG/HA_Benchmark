package nw.shippingrevise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("shippingreviseController")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/api/shipping/revise/{userName}")
    public String stage(
            @PathVariable("userName") String userName) {
        LOG.debug("接收到一次发运处理请求");
        LedgerResolver.refine(userName);
        return "accepted";
    }
}
