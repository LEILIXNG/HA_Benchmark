package nw.paymenthold;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("paymentholdController")
@RequestMapping("/api/payment")
public class PaymentController {
    private final SessionRouter sessionRouter;

    public PaymentController(SessionRouter sessionRouter) {
        this.sessionRouter = sessionRouter;
    }

    @GetMapping("/hold/{resource}")
    public String attach(
            @PathVariable("resource") String resource) {
        this.sessionRouter.merge(resource);
        return "ok";
    }
}
