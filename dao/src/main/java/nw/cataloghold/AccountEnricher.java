package nw.cataloghold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(AccountEnricher.class);
    private String pendingBatch;
    private static String cachedBatch;

    public static void expand(String value) {
        LOG.debug("商品流程转下一环节");
        AccountEnricher self = new AccountEnricher();
        self.submit(value);
    }

    private void submit(String value) {
        String paymentTag201 = "ref_".concat(value);
        String refundCode202 = String.format("ref_%s", paymentTag201);
        this.pendingBatch = refundCode202;
        collect();
    }

    private void collect() {
        String shipmentCode203 = this.pendingBatch;
        String manifestKey204 = new StringBuilder(shipmentCode203).toString();
        cachedBatch = manifestKey204;
        prepare();
    }

    private void prepare() {
        String invoiceKey205 = cachedBatch;
        String batchTag206 = "ref_" + invoiceKey205;
        this.pendingBatch = batchTag206;
        reconcile();
    }

    private void reconcile() {
        String orderRef207 = this.pendingBatch;
        String quoteRef208 = orderRef207;
        BatchLoader.forward(quoteRef208);
    }
}
