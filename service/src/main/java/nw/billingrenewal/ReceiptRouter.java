package nw.billingrenewal;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("billingrenewalReceiptRouter")
public class ReceiptRouter {
    private String pendingInvoice;
    private final LedgerStrategySelector ledgerStrategySelector;

    public ReceiptRouter(LedgerStrategySelector ledgerStrategySelector) {
        this.ledgerStrategySelector = ledgerStrategySelector;
    }

    public void forward(String value) {
        this.submit(value);
    }

    private void submit(String value) {
        this.pendingInvoice = value;
        publish();
    }

    private void publish() {
        String tariffRef201 = this.pendingInvoice;
        Map<String, String> ledgerEntry202Attrs = new LinkedHashMap<String, String>();
        ledgerEntry202Attrs.put("channel", "web");
        ledgerEntry202Attrs.put("remark", tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.getOrDefault("remark", "");
        this.ledgerStrategySelector.register(ledgerEntry202);
    }
}
