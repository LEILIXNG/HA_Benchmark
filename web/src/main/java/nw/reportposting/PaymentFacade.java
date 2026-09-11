package nw.reportposting;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向报表场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("reportpostingPaymentFacade")
public class PaymentFacade {
    private final LedgerStrategySelector ledgerStrategySelector;

    public PaymentFacade(LedgerStrategySelector ledgerStrategySelector) {
        this.ledgerStrategySelector = ledgerStrategySelector;
    }

    public void forward(String value) {
        Map<String, String> quoteRef101Attrs = new LinkedHashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("detail", value);
        String quoteRef101 = quoteRef101Attrs.getOrDefault("detail", "");
        this.ledgerStrategySelector.publish(quoteRef101);
    }
}
