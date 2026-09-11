package nw.fulfilledger;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfilledgerController")
public class PaymentController {
    private final LedgerCollector ledgerCollector;

    public PaymentController(LedgerCollector ledgerCollector) {
        this.ledgerCollector = ledgerCollector;
    }

    @GetMapping("/api/fulfil/ledger")
    public String attach(
            @CookieValue("payment_tag") String userName) {
        this.ledgerCollector.merge(userName);
        return "accepted";
    }
}
