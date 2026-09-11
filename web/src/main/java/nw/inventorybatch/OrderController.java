package nw.inventorybatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向库存场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("inventorybatchController")
@RequestMapping("/api/inventory")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final LedgerService ledgerService;

    public OrderController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @GetMapping("/batch")
    public String normalize(
            @CookieValue("order_trace") String filename) {
        LOG.debug("库存流程转下一环节");
        this.ledgerService.route(filename);
        return "done";
    }
}
