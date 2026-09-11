package nw.pricingrenewal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("pricingrenewalController")
@RequestMapping("/api/pricing")
public class LedgerController {
    private final ReceiptResolver receiptResolver;

    public LedgerController(ReceiptResolver receiptResolver) {
        this.receiptResolver = receiptResolver;
    }

    @GetMapping("/renewal")
    public ResponseEntity<String> submit(
            @RequestParam("filename") String filename) {
        this.receiptResolver.expand(filename);
        return ResponseEntity.ok("done");
    }
}
