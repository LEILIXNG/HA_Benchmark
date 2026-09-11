package nw.inventorysettlequeue;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("inventorysettlequeueController")
public class RefundController {
    private final TariffRegistry tariffRegistry;

    public RefundController(TariffRegistry tariffRegistry) {
        this.tariffRegistry = tariffRegistry;
    }

    @GetMapping("/api/inventory/settlequeue")
    public ResponseEntity<String> attach(HttpServletRequest request) {
        String label = request.getHeader("X-Refund-Client");
        this.tariffRegistry.stage(label);
        return ResponseEntity.ok("accepted");
    }
}
