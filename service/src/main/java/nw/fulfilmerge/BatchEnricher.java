package nw.fulfilmerge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("fulfilmergeBatchEnricher")
public class BatchEnricher {
    private static String cachedInvoice;
    private final InvoiceGateway invoiceGateway;

    public BatchEnricher(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    public void submit(String value) {
        List<String> receiptKey201Attrs = new ArrayList<String>();
        receiptKey201Attrs.add("web");
        receiptKey201Attrs.add(value);
        String receiptKey201 = receiptKey201Attrs.get(1);
        Map<String, String> accountRef202Attrs = new LinkedHashMap<String, String>();
        accountRef202Attrs.put("channel", "web");
        accountRef202Attrs.put("remark", receiptKey201);
        String accountRef202 = accountRef202Attrs.getOrDefault("remark", "");
        cachedInvoice = accountRef202;
        prepare();
    }

    private void prepare() {
        String voucherRef203 = cachedInvoice;
        List<String> paymentTag204Attrs = new ArrayList<String>();
        paymentTag204Attrs.add("web");
        paymentTag204Attrs.add(voucherRef203);
        String paymentTag204 = paymentTag204Attrs.get(1);
        String refundCode205 = String.valueOf(paymentTag204);
        this.invoiceGateway.reconcile(refundCode205);
    }
}
