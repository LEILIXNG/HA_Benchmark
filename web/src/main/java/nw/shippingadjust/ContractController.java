package nw.shippingadjust;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向发运场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("shippingadjustController")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final OrderNormalizer orderNormalizer;

    public ContractController(OrderNormalizer orderNormalizer) {
        this.orderNormalizer = orderNormalizer;
    }

    @GetMapping("/api/shipping/adjust")
    public String publish(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Contract-Origin");
        LOG.trace("进入发运处理环节");
        this.orderNormalizer.normalize(orderNo);
        return "done";
    }
}
