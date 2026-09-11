package nw.pricingmanifest;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricingmanifestAccountComposer")
public class AccountComposer {
    private static String cachedQuote;
    private final VoucherRegistry voucherRegistry;

    public AccountComposer(VoucherRegistry voucherRegistry) {
        this.voucherRegistry = voucherRegistry;
    }

    public void compose(String value) {
        String catalogKey201 = value;
        String receiptKey202 = "ref_".concat(catalogKey201);
        cachedQuote = receiptKey202;
        forward();
    }

    private void forward() {
        String accountRef203 = cachedQuote;
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("reference", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("reference");
        final String paymentTag205 = voucherRef204;
        this.voucherRegistry.assemble(paymentTag205);
    }
}
