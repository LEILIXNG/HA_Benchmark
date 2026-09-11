package nw.fulfilreview;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfilreviewController")
@RequestMapping("/api/fulfil")
public class VoucherController {
    private final PaymentRouter paymentRouter;

    public VoucherController(PaymentRouter paymentRouter) {
        this.paymentRouter = paymentRouter;
    }

    @GetMapping("/review")
    public String publish(
            @CookieValue("voucher_ctx") String resource) {
        this.paymentRouter.publish(resource);
        return "accepted";
    }
}
