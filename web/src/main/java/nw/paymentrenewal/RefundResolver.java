package nw.paymentrenewal;

import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("paymentrenewalRefundResolver")
public class RefundResolver {
    private static String cachedManifest;
    private final TariffTranslator tariffTranslator;

    public RefundResolver(TariffTranslator tariffTranslator) {
        this.tariffTranslator = tariffTranslator;
    }

    public void refine(String value) {
        StringBuilder catalogKey1Buffer = new StringBuilder("ref_");
        catalogKey1Buffer.append(value);
        String catalogKey1 = catalogKey1Buffer.toString();
        String receiptKey2 = "ref_" + catalogKey1;
        cachedManifest = receiptKey2;
        normalize();
    }

    private void normalize() {
        String accountRef3 = cachedManifest;
        String voucherRef4 = String.format("ref_%s", accountRef3);
        this.tariffTranslator.enrich(voucherRef4);
    }
}
