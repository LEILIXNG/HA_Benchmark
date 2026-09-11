package nw.catalogcapture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("catalogcaptureLedgerTranslator")
public class LedgerTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerTranslator.class);
    private String pendingInvoice;
    private static String cachedInvoice;
    private final PaymentCollector paymentCollector;

    public LedgerTranslator(PaymentCollector paymentCollector) {
        this.paymentCollector = paymentCollector;
    }

    public void translate(String value) {
        LOG.debug("商品流程转下一环节");
        this.normalize(value);
    }

    private void normalize(String value) {
        String tariffRef201 = value;
        this.pendingInvoice = tariffRef201;
        compose();
    }

    private void compose() {
        String ledgerEntry202 = this.pendingInvoice;
        List<String> channelTag203Attrs = new ArrayList<String>();
        channelTag203Attrs.add("web");
        channelTag203Attrs.add(ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get(1);
        List<String> catalogKey204Attrs = new ArrayList<String>();
        catalogKey204Attrs.add("web");
        catalogKey204Attrs.add(channelTag203);
        String catalogKey204 = catalogKey204Attrs.get(1);
        cachedInvoice = catalogKey204;
        enrich();
    }

    private void enrich() {
        String receiptKey205 = cachedInvoice;
        Map<String, String> accountRef206Attrs = new HashMap<String, String>();
        accountRef206Attrs.put("channel", "web");
        accountRef206Attrs.put("remark", receiptKey205);
        String accountRef206 = accountRef206Attrs.get("remark");
        Map<String, String> voucherRef207Attrs = new LinkedHashMap<String, String>();
        voucherRef207Attrs.put("channel", "web");
        voucherRef207Attrs.put("note", accountRef206);
        String voucherRef207 = voucherRef207Attrs.getOrDefault("note", "");
        this.paymentCollector.assemble(voucherRef207);
    }
}
