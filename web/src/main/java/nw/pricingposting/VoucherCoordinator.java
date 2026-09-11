package nw.pricingposting;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("pricingpostingVoucherCoordinator")
public class VoucherCoordinator {
    private String pendingBatch;
    private static String cachedBatch;
    private final BatchFacade batchFacade;

    public VoucherCoordinator(BatchFacade batchFacade) {
        this.batchFacade = batchFacade;
    }

    public void refine(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        String catalogKey1 = value;
        this.pendingBatch = catalogKey1;
        enrich();
    }

    private void enrich() {
        String receiptKey2 = this.pendingBatch;
        String accountRef3 = receiptKey2;
        cachedBatch = accountRef3;
        compose();
    }

    private void compose() {
        String voucherRef4 = cachedBatch;
        StringBuilder paymentTag5Buffer = new StringBuilder("ref_");
        paymentTag5Buffer.append(voucherRef4);
        String paymentTag5 = paymentTag5Buffer.toString();
        String refundCode6 = new StringBuilder(paymentTag5).toString();
        this.pendingBatch = refundCode6;
        submit();
    }

    private void submit() {
        String shipmentCode7 = this.pendingBatch;
        Map<String, String> manifestKey8Attrs = new HashMap<String, String>();
        manifestKey8Attrs.put("channel", "web");
        manifestKey8Attrs.put("reference", shipmentCode7);
        String manifestKey8 = manifestKey8Attrs.get("reference");
        String invoiceKey9 = String.valueOf(manifestKey8);
        cachedBatch = invoiceKey9;
        assemble();
    }

    private void assemble() {
        String batchTag10 = cachedBatch;
        String orderRef11 = "ref_".concat(batchTag10);
        String quoteRef12 = String.valueOf(orderRef11);
        cachedBatch = quoteRef12;
        route();
    }

    private void route() {
        String tariffRef13 = cachedBatch;
        String ledgerEntry14 = "ref_" + tariffRef13;
        cachedBatch = ledgerEntry14;
        register();
    }

    private void register() {
        String channelTag15 = cachedBatch;
        String catalogKey16 = "ref_" + channelTag15;
        this.pendingBatch = catalogKey16;
        normalize();
    }

    private void normalize() {
        String receiptKey17 = this.pendingBatch;
        String accountRef18 = receiptKey17;
        this.batchFacade.dispatch(accountRef18);
    }
}
