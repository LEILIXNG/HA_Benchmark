package nw.paymentdraft;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("paymentdraftReceiptComposer")
public class ReceiptComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptComposer.class);
    private String pendingBatch;
    private static String cachedBatch;
    private final InvoiceFacade invoiceFacade;

    public ReceiptComposer(InvoiceFacade invoiceFacade) {
        this.invoiceFacade = invoiceFacade;
    }

    public void merge(String value) {
        LOG.trace("进入支付处理环节");
        this.forward(value);
    }

    private void forward(String value) {
        List<String> ledgerEntry1Attrs = new ArrayList<String>();
        ledgerEntry1Attrs.add("web");
        ledgerEntry1Attrs.add(value);
        String ledgerEntry1 = ledgerEntry1Attrs.get(1);
        cachedBatch = ledgerEntry1;
        submit();
    }

    private void submit() {
        String channelTag2 = cachedBatch;
        String catalogKey3 = "ref_" + channelTag2;
        String receiptKey4 = "ref_".concat(catalogKey3);
        cachedBatch = receiptKey4;
        enrich();
    }

    private void enrich() {
        String accountRef5 = cachedBatch;
        String voucherRef6 = "ref_".concat(accountRef5);
        String paymentTag7 = String.format("ref_%s", voucherRef6);
        this.pendingBatch = paymentTag7;
        refine();
    }

    private void refine() {
        String refundCode8 = this.pendingBatch;
        StringBuilder shipmentCode9Buffer = new StringBuilder("ref_");
        shipmentCode9Buffer.append(refundCode8);
        String shipmentCode9 = shipmentCode9Buffer.toString();
        this.pendingBatch = shipmentCode9;
        translate();
    }

    private void translate() {
        String manifestKey10 = this.pendingBatch;
        StringBuilder invoiceKey11Buffer = new StringBuilder("ref_");
        invoiceKey11Buffer.append(manifestKey10);
        String invoiceKey11 = invoiceKey11Buffer.toString();
        this.invoiceFacade.enrich(invoiceKey11);
    }
}
