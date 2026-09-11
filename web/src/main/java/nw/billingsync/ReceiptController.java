package nw.billingsync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("billingsyncController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final ShipmentResolver shipmentResolver;

    public ReceiptController(ShipmentResolver shipmentResolver) {
        this.shipmentResolver = shipmentResolver;
    }

    @GetMapping("/api/billing/sync")
    public String refine(
            @CookieValue("receipt_trace") String filename) {
        LOG.debug("账务流程转下一环节");
        this.shipmentResolver.route(filename);
        return "accepted";
    }
}
