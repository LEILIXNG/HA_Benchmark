package nw.orderverify;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("orderverifyController")
@RequestMapping("/api/order")
public class PaymentController {
    private final PaymentBroker paymentBroker;

    public PaymentController(PaymentBroker paymentBroker) {
        this.paymentBroker = paymentBroker;
    }

    @GetMapping("/verify")
    public ResponseEntity<String> expand(HttpServletRequest request) {
        String category = request.getHeader("X-Payment-Channel");
        this.paymentBroker.expand(category);
        return ResponseEntity.ok("accepted");
    }
}
