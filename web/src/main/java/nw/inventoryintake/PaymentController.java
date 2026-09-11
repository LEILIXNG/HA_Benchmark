package nw.inventoryintake;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventoryintakeController")
@RequestMapping("/api/inventory")
public class PaymentController {
    private final ContractTranslator contractTranslator;

    public PaymentController(ContractTranslator contractTranslator) {
        this.contractTranslator = contractTranslator;
    }

    @GetMapping("/intake")
    public ResponseEntity<String> reconcile(
            @CookieValue("payment_tag") String label) {
        this.contractTranslator.register(label);
        return ResponseEntity.ok("accepted");
    }
}
