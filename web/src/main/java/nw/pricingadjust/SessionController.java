package nw.pricingadjust;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("pricingadjustController")
@RequestMapping("/api/pricing")
public class SessionController {
    private final QuoteBuilder quoteBuilder;

    public SessionController(QuoteBuilder quoteBuilder) {
        this.quoteBuilder = quoteBuilder;
    }

    @GetMapping("/adjust/{orderNo}")
    public ResponseEntity<String> reconcile(
            @PathVariable("orderNo") String orderNo) {
        this.quoteBuilder.compose(orderNo);
        return ResponseEntity.ok("ok");
    }
}
