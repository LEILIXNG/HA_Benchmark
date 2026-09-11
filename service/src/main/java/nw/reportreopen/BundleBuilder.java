package nw.reportreopen;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("reportreopenBundleBuilder")
public class BundleBuilder {
    private static String cachedBatch;
    private final PaymentTranslator paymentTranslator;

    public BundleBuilder(PaymentTranslator paymentTranslator) {
        this.paymentTranslator = paymentTranslator;
    }

    public void submit(String value) {
        String ledgerEntry201 = String.valueOf(value);
        cachedBatch = ledgerEntry201;
        collect();
    }

    private void collect() {
        String channelTag202 = cachedBatch;
        List<String> catalogKey203Attrs = new ArrayList<String>();
        catalogKey203Attrs.add("web");
        catalogKey203Attrs.add(channelTag202);
        String catalogKey203 = catalogKey203Attrs.get(1);
        this.paymentTranslator.enrich(catalogKey203);
    }
}
