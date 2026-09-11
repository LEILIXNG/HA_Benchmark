package nw.catalogdispatch;

import org.springframework.stereotype.Repository;

/**
 * 商品处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("catalogdispatchVoucherService")
public class VoucherService {
    private static String cachedChannel;
    private final QuoteFilter quoteFilter;

    public VoucherService(QuoteFilter quoteFilter) {
        this.quoteFilter = quoteFilter;
    }

    public void refine(String value) {
        String voucherRef501 = value;
        String paymentTag502 = "ref_" + voucherRef501;
        cachedChannel = paymentTag502;
        dispatch();
    }

    private void dispatch() {
        String refundCode503 = cachedChannel;
        String shipmentCode504 = new StringBuilder(refundCode503).toString();
        cachedChannel = shipmentCode504;
        prepare();
    }

    private void prepare() {
        String manifestKey505 = cachedChannel;
        String invoiceKey506 = String.format("ref_%s", manifestKey505);
        cachedChannel = invoiceKey506;
        collect();
    }

    private void collect() {
        String batchTag507 = cachedChannel;
        String orderRef508 = batchTag507;
        String quoteRef509 = "ref_" + orderRef508;
        this.quoteFilter.enrich(quoteRef509);
    }
}
