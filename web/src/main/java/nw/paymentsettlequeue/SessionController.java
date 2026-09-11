package nw.paymentsettlequeue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("paymentsettlequeueController")
public class SessionController {
    private final AccountTranslator accountTranslator;

    public SessionController(AccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @GetMapping("/api/payment/settlequeue/{label}")
    public ResponseEntity<String> refine(
            @PathVariable("label") String label) {
        this.accountTranslator.refine(label);
        return ResponseEntity.ok("ok");
    }
}
