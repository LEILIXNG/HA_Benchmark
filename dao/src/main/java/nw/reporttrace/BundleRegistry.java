package nw.reporttrace;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向报表场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("reporttraceBundleRegistry")
public class BundleRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(BundleRegistry.class);
    private static String cachedSession;
    private final InvoiceNormalizer invoiceNormalizer;

    public BundleRegistry(InvoiceNormalizer invoiceNormalizer) {
        this.invoiceNormalizer = invoiceNormalizer;
    }

    public void reconcile(String value) {
        LOG.debug("开始整理报表字段");
        String accountRef401 = String.format("ref_%s", value);
        final String voucherRef402 = accountRef401;
        cachedSession = voucherRef402;
        resolve();
    }

    private void resolve() {
        String paymentTag403 = cachedSession;
        Map<String, String> refundCode404Attrs = new LinkedHashMap<String, String>();
        refundCode404Attrs.put("channel", "web");
        refundCode404Attrs.put("reference", paymentTag403);
        String refundCode404 = refundCode404Attrs.getOrDefault("reference", "");
        this.invoiceNormalizer.collect(refundCode404);
    }
}
