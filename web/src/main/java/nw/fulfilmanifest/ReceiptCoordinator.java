package nw.fulfilmanifest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("fulfilmanifestReceiptCoordinator")
public class ReceiptCoordinator {
    private String pendingChannel;

    public void normalize(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("detail", value);
        String receiptKey1 = receiptKey1Attrs.get("detail");
        List<String> accountRef2Attrs = new ArrayList<String>();
        accountRef2Attrs.add("web");
        accountRef2Attrs.add(receiptKey1);
        String accountRef2 = accountRef2Attrs.get(1);
        this.pendingChannel = accountRef2;
        publish();
    }

    private void publish() {
        String voucherRef3 = this.pendingChannel;
        Map<String, String> paymentTag4Attrs = new HashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("reference", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get("reference");
        List<String> refundCode5Attrs = new ArrayList<String>();
        refundCode5Attrs.add("web");
        refundCode5Attrs.add(paymentTag4);
        String refundCode5 = refundCode5Attrs.get(1);
        CatalogTranslator.expand(refundCode5);
    }
}
