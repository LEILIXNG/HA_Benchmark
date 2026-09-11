package nw.vendormerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendormergePaymentBroker")
public class PaymentBroker {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentBroker.class);
    private static String cachedCatalog;
    private final CatalogPolicySelector catalogPolicySelector;

    public PaymentBroker(CatalogPolicySelector catalogPolicySelector) {
        this.catalogPolicySelector = catalogPolicySelector;
    }

    public void normalize(String value) {
        LOG.trace("进入供应商处理环节");
        String batchTag201 = String.valueOf(value);
        String orderRef202 = batchTag201;
        cachedCatalog = orderRef202;
        publish();
    }

    private void publish() {
        String quoteRef203 = cachedCatalog;
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("reference", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("reference");
        cachedCatalog = tariffRef204;
        submit();
    }

    private void submit() {
        String ledgerEntry205 = cachedCatalog;
        final String channelTag206 = ledgerEntry205;
        List<String> catalogKey207Attrs = new ArrayList<String>();
        catalogKey207Attrs.add("web");
        catalogKey207Attrs.add(channelTag206);
        String catalogKey207 = catalogKey207Attrs.get(1);
        cachedCatalog = catalogKey207;
        compose();
    }

    private void compose() {
        String receiptKey208 = cachedCatalog;
        String accountRef209 = "ref_".concat(receiptKey208);
        Map<String, String> voucherRef210Attrs = new LinkedHashMap<String, String>();
        voucherRef210Attrs.put("channel", "web");
        voucherRef210Attrs.put("remark", accountRef209);
        String voucherRef210 = voucherRef210Attrs.getOrDefault("remark", "");
        this.catalogPolicySelector.collect(voucherRef210);
    }
}
