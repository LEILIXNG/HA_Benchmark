package nw.shippingclose;

import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("shippingcloseCatalogTranslator")
public class CatalogTranslator {
    private String pendingOrder;
    private final BatchTranslator batchTranslator;

    public CatalogTranslator(BatchTranslator batchTranslator) {
        this.batchTranslator = batchTranslator;
    }

    public void normalize(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        String channelTag201 = String.format("ref_%s", value);
        this.pendingOrder = channelTag201;
        attach();
    }

    private void attach() {
        String catalogKey202 = this.pendingOrder;
        String receiptKey203 = String.format("ref_%s", catalogKey202);
        StringBuilder accountRef204Buffer = new StringBuilder("ref_");
        accountRef204Buffer.append(receiptKey203);
        String accountRef204 = accountRef204Buffer.toString();
        this.pendingOrder = accountRef204;
        prepare();
    }

    private void prepare() {
        String voucherRef205 = this.pendingOrder;
        String paymentTag206 = voucherRef205;
        this.batchTranslator.assemble(paymentTag206);
    }
}
