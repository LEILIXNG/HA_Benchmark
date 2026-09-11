package nw.orderreview;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("orderreviewController")
public class PaymentController {
    private final ContractBroker contractBroker;

    public PaymentController(ContractBroker contractBroker) {
        this.contractBroker = contractBroker;
    }

    @GetMapping("/api/order/review")
    public String resolve(
            @CookieValue("payment_trace") String orderNo) {
        this.contractBroker.translate(orderNo);
        return "accepted";
    }
}
