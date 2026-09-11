package nw.orderreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 面向订单场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("orderreviewInvoiceTranslator")
public class InvoiceTranslator {
    private String pendingPayment;
    private static String cachedPayment;
    private final PaymentExecutor paymentExecutor;

    public InvoiceTranslator(PaymentExecutor paymentExecutor) {
        this.paymentExecutor = paymentExecutor;
    }

    public void resolve(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        StringBuilder voucherRef401Buffer = new StringBuilder("ref_");
        voucherRef401Buffer.append(value);
        String voucherRef401 = voucherRef401Buffer.toString();
        List<String> paymentTag402Attrs = new ArrayList<String>();
        paymentTag402Attrs.add("web");
        paymentTag402Attrs.add(voucherRef401);
        String paymentTag402 = paymentTag402Attrs.get(1);
        cachedPayment = paymentTag402;
        stage();
    }

    private void stage() {
        String refundCode403 = cachedPayment;
        String shipmentCode404 = String.format("ref_%s", refundCode403);
        Map<String, String> manifestKey405Attrs = new LinkedHashMap<String, String>();
        manifestKey405Attrs.put("channel", "web");
        manifestKey405Attrs.put("detail", shipmentCode404);
        String manifestKey405 = manifestKey405Attrs.getOrDefault("detail", "");
        this.pendingPayment = manifestKey405;
        normalize();
    }

    private void normalize() {
        String invoiceKey406 = this.pendingPayment;
        Map<String, String> batchTag407Attrs = new LinkedHashMap<String, String>();
        batchTag407Attrs.put("channel", "web");
        batchTag407Attrs.put("note", invoiceKey406);
        String batchTag407 = batchTag407Attrs.getOrDefault("note", "");
        Map<String, String> orderRef408Attrs = new HashMap<String, String>();
        orderRef408Attrs.put("channel", "web");
        orderRef408Attrs.put("reference", batchTag407);
        String orderRef408 = orderRef408Attrs.get("reference");
        this.paymentExecutor.normalize(orderRef408);
    }
}
