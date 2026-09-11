package nw.billingverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingverifyController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final VoucherCoordinator voucherCoordinator;

    public CatalogController(VoucherCoordinator voucherCoordinator) {
        this.voucherCoordinator = voucherCoordinator;
    }

    @GetMapping("/api/billing/verify")
    public ResponseEntity<String> forward(
            @RequestHeader("X-Catalog-Reference") String category) {
        LOG.trace("进入账务处理环节");
        this.voucherCoordinator.prepare(category);
        return ResponseEntity.ok("ok");
    }
}
