package nw.inventorygrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("inventorygrantController")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final AccountBuilder accountBuilder;

    public OrderController(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    @GetMapping("/api/inventory/grant")
    public ResponseEntity<String> prepare(
            @RequestHeader("X-Order-Tenant") String label) {
        LOG.debug("库存流程转下一环节");
        this.accountBuilder.register(label);
        return ResponseEntity.ok("ok");
    }
}
