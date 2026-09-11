package nw.vendorassign;

import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorassignInvoiceCollector")
public class InvoiceCollector {
    private static String cachedManifest;
    private final TariffStrategySelector tariffStrategySelector;

    public InvoiceCollector(TariffStrategySelector tariffStrategySelector) {
        this.tariffStrategySelector = tariffStrategySelector;
    }

    public void register(String value) {
        String catalogKey1 = String.valueOf(value);
        cachedManifest = catalogKey1;
        normalize();
    }

    private void normalize() {
        String receiptKey2 = cachedManifest;
        String accountRef3 = String.format("ref_%s", receiptKey2);
        StringBuilder voucherRef4Buffer = new StringBuilder("ref_");
        voucherRef4Buffer.append(accountRef3);
        String voucherRef4 = voucherRef4Buffer.toString();
        cachedManifest = voucherRef4;
        publish();
    }

    private void publish() {
        String paymentTag5 = cachedManifest;
        final String refundCode6 = paymentTag5;
        this.tariffStrategySelector.collect(refundCode6);
    }
}
