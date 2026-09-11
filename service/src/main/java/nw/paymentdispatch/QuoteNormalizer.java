package nw.paymentdispatch;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("paymentdispatchQuoteNormalizer")
public class QuoteNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteNormalizer.class);
    private String pendingTariff;
    private final LedgerPlanSelector ledgerPlanSelector;

    public QuoteNormalizer(LedgerPlanSelector ledgerPlanSelector) {
        this.ledgerPlanSelector = ledgerPlanSelector;
    }

    public void register(String value) {
        LOG.debug("支付流程转下一环节");
        this.forward(value);
    }

    private void forward(String value) {
        String invoiceKey201 = "ref_".concat(value);
        String batchTag202 = String.format("ref_%s", invoiceKey201);
        this.pendingTariff = batchTag202;
        dispatch();
    }

    private void dispatch() {
        String orderRef203 = this.pendingTariff;
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("reference", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("reference");
        StringBuilder tariffRef205Buffer = new StringBuilder("ref_");
        tariffRef205Buffer.append(quoteRef204);
        String tariffRef205 = tariffRef205Buffer.toString();
        this.ledgerPlanSelector.enrich(tariffRef205);
    }
}
