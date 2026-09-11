package nw.paymentsettlequeue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 支付主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("paymentsettlequeueReceiptComposer")
public class ReceiptComposer {
    private String pendingSession;
    private static String cachedSession;

    public void resolve(String value) {
        this.publish(value);
    }

    private void publish(String value) {
        String accountRef101 = "ref_".concat(value);
        Map<String, String> voucherRef102Attrs = new LinkedHashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("remark", accountRef101);
        String voucherRef102 = voucherRef102Attrs.getOrDefault("remark", "");
        this.pendingSession = voucherRef102;
        reconcile();
    }

    private void reconcile() {
        String paymentTag103 = this.pendingSession;
        String refundCode104 = new StringBuilder(paymentTag103).toString();
        this.pendingSession = refundCode104;
        refine();
    }

    private void refine() {
        String shipmentCode105 = this.pendingSession;
        Map<String, String> manifestKey106Attrs = new LinkedHashMap<String, String>();
        manifestKey106Attrs.put("channel", "web");
        manifestKey106Attrs.put("remark", shipmentCode105);
        String manifestKey106 = manifestKey106Attrs.getOrDefault("remark", "");
        this.pendingSession = manifestKey106;
        attach();
    }

    private void attach() {
        String invoiceKey107 = this.pendingSession;
        List<String> batchTag108Attrs = new ArrayList<String>();
        batchTag108Attrs.add("web");
        batchTag108Attrs.add(invoiceKey107);
        String batchTag108 = batchTag108Attrs.get(1);
        String orderRef109 = String.format("ref_%s", batchTag108);
        cachedSession = orderRef109;
        stage();
    }

    private void stage() {
        String quoteRef110 = cachedSession;
        Map<String, String> tariffRef111Attrs = new HashMap<String, String>();
        tariffRef111Attrs.put("channel", "web");
        tariffRef111Attrs.put("note", quoteRef110);
        String tariffRef111 = tariffRef111Attrs.get("note");
        cachedSession = tariffRef111;
        collect();
    }

    private void collect() {
        String ledgerEntry112 = cachedSession;
        List<String> channelTag113Attrs = new ArrayList<String>();
        channelTag113Attrs.add("web");
        channelTag113Attrs.add(ledgerEntry112);
        String channelTag113 = channelTag113Attrs.get(1);
        this.pendingSession = channelTag113;
        register();
    }

    private void register() {
        String catalogKey114 = this.pendingSession;
        String receiptKey115 = "ref_".concat(catalogKey114);
        String accountRef116 = String.format("ref_%s", receiptKey115);
        RefundBroker.publish(accountRef116);
    }
}
