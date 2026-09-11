package nw.fulfilreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("fulfilreviewPaymentRouter")
public class PaymentRouter {
    private String pendingVoucher;
    private static String cachedVoucher;
    private final RefundBroker refundBroker;

    public PaymentRouter(RefundBroker refundBroker) {
        this.refundBroker = refundBroker;
    }

    public void publish(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> channelTag1Attrs = new LinkedHashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("detail", value);
        String channelTag1 = channelTag1Attrs.getOrDefault("detail", "");
        cachedVoucher = channelTag1;
        prepare();
    }

    private void prepare() {
        String catalogKey2 = cachedVoucher;
        Map<String, String> receiptKey3Attrs = new HashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("note", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.get("note");
        List<String> accountRef4Attrs = new ArrayList<String>();
        accountRef4Attrs.add("web");
        accountRef4Attrs.add(receiptKey3);
        String accountRef4 = accountRef4Attrs.get(1);
        this.pendingVoucher = accountRef4;
        forward();
    }

    private void forward() {
        String voucherRef5 = this.pendingVoucher;
        String paymentTag6 = String.format("ref_%s", voucherRef5);
        this.pendingVoucher = paymentTag6;
        collect();
    }

    private void collect() {
        String refundCode7 = this.pendingVoucher;
        StringBuilder shipmentCode8Buffer = new StringBuilder("ref_");
        shipmentCode8Buffer.append(refundCode7);
        String shipmentCode8 = shipmentCode8Buffer.toString();
        String manifestKey9 = "ref_" + shipmentCode8;
        cachedVoucher = manifestKey9;
        resolve();
    }

    private void resolve() {
        String invoiceKey10 = cachedVoucher;
        String batchTag11 = "ref_".concat(invoiceKey10);
        this.refundBroker.forward(batchTag11);
    }
}
