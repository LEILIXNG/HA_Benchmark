package nw.paymentintake;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("paymentintakeController")
@RequestMapping("/api/payment")
public class VoucherController {
    private final CatalogBroker catalogBroker;

    public VoucherController(CatalogBroker catalogBroker) {
        this.catalogBroker = catalogBroker;
    }

    @GetMapping("/intake")
    public ResponseEntity<String> assemble(
            @RequestParam("userName") String userName) {
        this.catalogBroker.reconcile(userName);
        return ResponseEntity.ok("accepted");
    }
}
