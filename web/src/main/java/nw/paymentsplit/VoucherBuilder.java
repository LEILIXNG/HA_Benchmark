package nw.paymentsplit;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("paymentsplitVoucherBuilder")
public class VoucherBuilder {
    private static String cachedRefund;
    private final VoucherRuleSelector voucherRuleSelector;

    public VoucherBuilder(VoucherRuleSelector voucherRuleSelector) {
        this.voucherRuleSelector = voucherRuleSelector;
    }

    public void attach(String value) {
        String batchTag1 = String.valueOf(value);
        cachedRefund = batchTag1;
        stage();
    }

    private void stage() {
        String orderRef2 = cachedRefund;
        Map<String, String> quoteRef3Attrs = new HashMap<String, String>();
        quoteRef3Attrs.put("channel", "web");
        quoteRef3Attrs.put("note", orderRef2);
        String quoteRef3 = quoteRef3Attrs.get("note");
        cachedRefund = quoteRef3;
        register();
    }

    private void register() {
        String tariffRef4 = cachedRefund;
        String ledgerEntry5 = new StringBuilder(tariffRef4).toString();
        this.voucherRuleSelector.translate(ledgerEntry5);
    }
}
