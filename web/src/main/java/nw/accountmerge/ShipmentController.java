package nw.accountmerge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("accountmergeController")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final InvoiceNormalizer invoiceNormalizer;

    public ShipmentController(InvoiceNormalizer invoiceNormalizer) {
        this.invoiceNormalizer = invoiceNormalizer;
    }

    @GetMapping("/api/account/merge")
    public ResponseEntity<String> compose(
            @RequestParam("query") String query) {
        LOG.debug("账户流程转下一环节");
        this.invoiceNormalizer.dispatch(query);
        return ResponseEntity.ok("accepted");
    }
}
