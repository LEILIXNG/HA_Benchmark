package nw.orderdigest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("orderdigestVoucherBroker")
public class VoucherBroker {
    private String pendingRefund;
    private static String cachedRefund;
    private final RefundEvaluator refundEvaluator;

    public VoucherBroker(RefundEvaluator refundEvaluator) {
        this.refundEvaluator = refundEvaluator;
    }

    public void dispatch(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        StringBuilder ledgerEntry101Buffer = new StringBuilder("ref_");
        ledgerEntry101Buffer.append(value);
        String ledgerEntry101 = ledgerEntry101Buffer.toString();
        cachedRefund = ledgerEntry101;
        register();
    }

    private void register() {
        String channelTag102 = cachedRefund;
        String catalogKey103 = String.valueOf(channelTag102);
        List<String> receiptKey104Attrs = new ArrayList<String>();
        receiptKey104Attrs.add("web");
        receiptKey104Attrs.add(catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get(1);
        cachedRefund = receiptKey104;
        normalize();
    }

    private void normalize() {
        String accountRef105 = cachedRefund;
        final String voucherRef106 = accountRef105;
        cachedRefund = voucherRef106;
        translate();
    }

    private void translate() {
        String paymentTag107 = cachedRefund;
        String refundCode108 = String.valueOf(paymentTag107);
        String shipmentCode109 = refundCode108;
        this.pendingRefund = shipmentCode109;
        compose();
    }

    private void compose() {
        String manifestKey110 = this.pendingRefund;
        String invoiceKey111 = "ref_".concat(manifestKey110);
        this.pendingRefund = invoiceKey111;
        assemble();
    }

    private void assemble() {
        String batchTag112 = this.pendingRefund;
        String orderRef113 = "ref_".concat(batchTag112);
        this.refundEvaluator.stage(orderRef113);
    }
}
