package nw.inventorysplit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("inventorysplitController")
public class ManifestController {
    private final RefundAssembler refundAssembler;

    public ManifestController(RefundAssembler refundAssembler) {
        this.refundAssembler = refundAssembler;
    }

    @GetMapping("/api/inventory/split")
    public ResponseEntity<String> register(
            @RequestParam("orderNo") String orderNo) {
        this.refundAssembler.expand(orderNo);
        return ResponseEntity.ok("ok");
    }
}
