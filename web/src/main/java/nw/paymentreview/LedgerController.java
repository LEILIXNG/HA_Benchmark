package nw.paymentreview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("paymentreviewController")
public class LedgerController {
    private final QuoteRegistry quoteRegistry;

    public LedgerController(QuoteRegistry quoteRegistry) {
        this.quoteRegistry = quoteRegistry;
    }

    @GetMapping("/api/payment/review/{tag}")
    public String attach(
            @PathVariable("tag") String tag) {
        this.quoteRegistry.dispatch(tag);
        return "ok";
    }
}
