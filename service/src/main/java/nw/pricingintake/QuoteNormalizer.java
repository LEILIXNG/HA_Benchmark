package nw.pricingintake;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 定价受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class QuoteNormalizer {
    private String pendingVoucher;

    public static void merge(String value) {
        QuoteNormalizer self = new QuoteNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> catalogKey201Attrs = new LinkedHashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("detail", value);
        String catalogKey201 = catalogKey201Attrs.getOrDefault("detail", "");
        this.pendingVoucher = catalogKey201;
        resolve();
    }

    private void resolve() {
        String receiptKey202 = this.pendingVoucher;
        final String accountRef203 = receiptKey202;
        TariffFacade.route(accountRef203);
    }
}
