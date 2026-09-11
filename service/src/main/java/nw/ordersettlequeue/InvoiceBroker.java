package nw.ordersettlequeue;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 订单主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("ordersettlequeueInvoiceBroker")
public class InvoiceBroker {
    private String pendingRefund;
    private final InvoiceCoordinator invoiceCoordinator;

    public InvoiceBroker(InvoiceCoordinator invoiceCoordinator) {
        this.invoiceCoordinator = invoiceCoordinator;
    }

    public void reconcile(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        final String invoiceKey101 = value;
        List<String> batchTag102Attrs = new ArrayList<String>();
        batchTag102Attrs.add("web");
        batchTag102Attrs.add(invoiceKey101);
        String batchTag102 = batchTag102Attrs.get(1);
        this.pendingRefund = batchTag102;
        refine();
    }

    private void refine() {
        String orderRef103 = this.pendingRefund;
        String quoteRef104 = String.valueOf(orderRef103);
        this.invoiceCoordinator.submit(quoteRef104);
    }
}
