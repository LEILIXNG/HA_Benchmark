package nw.shippingreopen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 发运明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("shippingreopenBatchCollector")
public class BatchCollector {
    private String pendingPayment;
    private final VoucherComposer voucherComposer;

    public BatchCollector(VoucherComposer voucherComposer) {
        this.voucherComposer = voucherComposer;
    }

    public void reconcile(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String tariffRef1 = "ref_".concat(value);
        List<String> ledgerEntry2Attrs = new ArrayList<String>();
        ledgerEntry2Attrs.add("web");
        ledgerEntry2Attrs.add(tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get(1);
        this.pendingPayment = ledgerEntry2;
        enrich();
    }

    private void enrich() {
        String channelTag3 = this.pendingPayment;
        String catalogKey4 = "ref_" + channelTag3;
        List<String> receiptKey5Attrs = new ArrayList<String>();
        receiptKey5Attrs.add("web");
        receiptKey5Attrs.add(catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get(1);
        this.pendingPayment = receiptKey5;
        publish();
    }

    private void publish() {
        String accountRef6 = this.pendingPayment;
        StringBuilder voucherRef7Buffer = new StringBuilder("ref_");
        voucherRef7Buffer.append(accountRef6);
        String voucherRef7 = voucherRef7Buffer.toString();
        Map<String, String> paymentTag8Attrs = new LinkedHashMap<String, String>();
        paymentTag8Attrs.put("channel", "web");
        paymentTag8Attrs.put("reference", voucherRef7);
        String paymentTag8 = paymentTag8Attrs.getOrDefault("reference", "");
        this.voucherComposer.reconcile(paymentTag8);
    }
}
