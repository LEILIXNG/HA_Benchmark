package nw.vendorsplit;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("vendorsplitController")
public class PaymentController {
    private final ReceiptAssembler receiptAssembler;

    public PaymentController(ReceiptAssembler receiptAssembler) {
        this.receiptAssembler = receiptAssembler;
    }

    @GetMapping("/api/vendor/split")
    public ResponseEntity<String> route(HttpServletRequest request) {
        String filename = request.getHeader("X-Payment-Trace");
        this.receiptAssembler.attach(filename);
        return ResponseEntity.ok("accepted");
    }
}
