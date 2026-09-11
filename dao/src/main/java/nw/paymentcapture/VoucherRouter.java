package nw.paymentcapture;

import org.springframework.stereotype.Repository;

/**
 * 支付受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("paymentcaptureVoucherRouter")
public class VoucherRouter {
    private String pendingBundle;
    private static String cachedBundle;
    private final QuoteScreen quoteScreen;

    public VoucherRouter(QuoteScreen quoteScreen) {
        this.quoteScreen = quoteScreen;
    }

    public void assemble(String value) {
        this.publish(value);
    }

    private void publish(String value) {
        String refundCode301 = "ref_" + value;
        this.pendingBundle = refundCode301;
        register();
    }

    private void register() {
        String shipmentCode302 = this.pendingBundle;
        final String manifestKey303 = shipmentCode302;
        cachedBundle = manifestKey303;
        resolve();
    }

    private void resolve() {
        String invoiceKey304 = cachedBundle;
        String batchTag305 = String.format("ref_%s", invoiceKey304);
        this.quoteScreen.submit(batchTag305);
    }
}
