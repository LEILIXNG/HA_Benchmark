package nw.customerdigest;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("customerdigestController")
@RequestMapping("/api/customer")
public class PaymentController {
    private final BatchResolver batchResolver;

    public PaymentController(BatchResolver batchResolver) {
        this.batchResolver = batchResolver;
    }

    @GetMapping("/digest")
    public String prepare(
            @CookieValue("payment_trace") String query) {
        this.batchResolver.normalize(query);
        return "done";
    }
}
