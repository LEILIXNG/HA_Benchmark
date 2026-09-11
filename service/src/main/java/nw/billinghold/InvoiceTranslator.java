package nw.billinghold;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("billingholdInvoiceTranslator")
public class InvoiceTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceTranslator.class);
    private String pendingReceipt;
    private static String cachedReceipt;
    private final PaymentPlanSelector paymentPlanSelector;

    public InvoiceTranslator(PaymentPlanSelector paymentPlanSelector) {
        this.paymentPlanSelector = paymentPlanSelector;
    }

    public void assemble(String value) {
        LOG.debug("开始整理账务字段");
        this.expand(value);
    }

    private void expand(String value) {
        Map<String, String> tariffRef201Attrs = new LinkedHashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("detail", value);
        String tariffRef201 = tariffRef201Attrs.getOrDefault("detail", "");
        final String ledgerEntry202 = tariffRef201;
        this.pendingReceipt = ledgerEntry202;
        attach();
    }

    private void attach() {
        String channelTag203 = this.pendingReceipt;
        String catalogKey204 = channelTag203;
        this.pendingReceipt = catalogKey204;
        register();
    }

    private void register() {
        String receiptKey205 = this.pendingReceipt;
        String accountRef206 = String.format("ref_%s", receiptKey205);
        String voucherRef207 = String.valueOf(accountRef206);
        cachedReceipt = voucherRef207;
        dispatch();
    }

    private void dispatch() {
        String paymentTag208 = cachedReceipt;
        String refundCode209 = "ref_" + paymentTag208;
        List<String> shipmentCode210Attrs = new ArrayList<String>();
        shipmentCode210Attrs.add("web");
        shipmentCode210Attrs.add(refundCode209);
        String shipmentCode210 = shipmentCode210Attrs.get(1);
        this.paymentPlanSelector.assemble(shipmentCode210);
    }
}
