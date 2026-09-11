package nw.customerdraft;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("customerdraftController")
@RequestMapping("/api/customer")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final RefundTranslator refundTranslator;

    public ShipmentController(RefundTranslator refundTranslator) {
        this.refundTranslator = refundTranslator;
    }

    @GetMapping("/draft")
    public String enrich(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Shipment-Context");
        LOG.trace("进入客户处理环节");
        this.refundTranslator.collect(orderNo);
        return "ok";
    }
}
