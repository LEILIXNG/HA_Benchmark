package nw.paymentbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("paymentbatchController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final RefundBuilder refundBuilder;

    public ReceiptController(RefundBuilder refundBuilder) {
        this.refundBuilder = refundBuilder;
    }

    @GetMapping("/api/payment/batch")
    public String refine(
            @CookieValue("receipt_token") String userName) {
        LOG.debug("支付流程转下一环节");
        this.refundBuilder.prepare(userName);
        return "accepted";
    }
}
