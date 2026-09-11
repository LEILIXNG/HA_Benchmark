package nw.orderintake;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("orderintakeLedgerAssembler")
public class LedgerAssembler {
    private final ReceiptRuleSelector receiptRuleSelector;

    public LedgerAssembler(ReceiptRuleSelector receiptRuleSelector) {
        this.receiptRuleSelector = receiptRuleSelector;
    }

    public void refine(String value) {
        Map<String, String> tariffRef201Attrs = new LinkedHashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("detail", value);
        String tariffRef201 = tariffRef201Attrs.getOrDefault("detail", "");
        String ledgerEntry202 = tariffRef201;
        this.receiptRuleSelector.collect(ledgerEntry202);
    }
}
