package nw.vendorapprove;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("vendorapproveController")
@RequestMapping("/api/vendor")
public class ReceiptController {
    private final PaymentService paymentService;

    public ReceiptController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/approve")
    public ResponseEntity<String> publish(
            @RequestParam("tag") String tag) {
        this.paymentService.resolve(tag);
        return ResponseEntity.ok("ok");
    }
}
