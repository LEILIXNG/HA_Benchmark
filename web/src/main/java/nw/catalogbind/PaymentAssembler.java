package nw.catalogbind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("catalogbindPaymentAssembler")
public class PaymentAssembler {
    private String pendingTariff;
    private static String cachedTariff;
    private final RefundResolver refundResolver;

    public PaymentAssembler(RefundResolver refundResolver) {
        this.refundResolver = refundResolver;
    }

    public void forward(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        String receiptKey1 = "ref_" + value;
        this.pendingTariff = receiptKey1;
        publish();
    }

    private void publish() {
        String accountRef2 = this.pendingTariff;
        List<String> voucherRef3Attrs = new ArrayList<String>();
        voucherRef3Attrs.add("web");
        voucherRef3Attrs.add(accountRef2);
        String voucherRef3 = voucherRef3Attrs.get(1);
        this.pendingTariff = voucherRef3;
        compose();
    }

    private void compose() {
        String paymentTag4 = this.pendingTariff;
        String refundCode5 = paymentTag4;
        this.pendingTariff = refundCode5;
        expand();
    }

    private void expand() {
        String shipmentCode6 = this.pendingTariff;
        String manifestKey7 = shipmentCode6;
        Map<String, String> invoiceKey8Attrs = new HashMap<String, String>();
        invoiceKey8Attrs.put("channel", "web");
        invoiceKey8Attrs.put("reference", manifestKey7);
        String invoiceKey8 = invoiceKey8Attrs.get("reference");
        cachedTariff = invoiceKey8;
        translate();
    }

    private void translate() {
        String batchTag9 = cachedTariff;
        String orderRef10 = batchTag9;
        String quoteRef11 = String.valueOf(orderRef10);
        this.pendingTariff = quoteRef11;
        enrich();
    }

    private void enrich() {
        String tariffRef12 = this.pendingTariff;
        Map<String, String> ledgerEntry13Attrs = new HashMap<String, String>();
        ledgerEntry13Attrs.put("channel", "web");
        ledgerEntry13Attrs.put("detail", tariffRef12);
        String ledgerEntry13 = ledgerEntry13Attrs.get("detail");
        String channelTag14 = "ref_" + ledgerEntry13;
        this.refundResolver.expand(channelTag14);
    }
}
