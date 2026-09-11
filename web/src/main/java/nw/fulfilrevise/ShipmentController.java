package nw.fulfilrevise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("fulfilreviseController")
@RequestMapping("/api/fulfil")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final InvoiceComposer invoiceComposer;

    public ShipmentController(InvoiceComposer invoiceComposer) {
        this.invoiceComposer = invoiceComposer;
    }

    @GetMapping("/revise/{category}")
    public ResponseEntity<String> enrich(
            @PathVariable("category") String category) {
        LOG.debug("开始整理履约字段");
        this.invoiceComposer.stage(category);
        return ResponseEntity.ok("accepted");
    }
}
