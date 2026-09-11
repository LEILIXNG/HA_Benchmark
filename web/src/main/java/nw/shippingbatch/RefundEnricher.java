package nw.shippingbatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("shippingbatchRefundEnricher")
public class RefundEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(RefundEnricher.class);
    private static String cachedCatalog;

    public void route(String value) {
        LOG.trace("进入发运处理环节");
        List<String> orderRef1Attrs = new ArrayList<String>();
        orderRef1Attrs.add("web");
        orderRef1Attrs.add(value);
        String orderRef1 = orderRef1Attrs.get(1);
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("remark", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("remark");
        cachedCatalog = quoteRef2;
        publish();
    }

    private void publish() {
        String tariffRef3 = cachedCatalog;
        Map<String, String> ledgerEntry4Attrs = new LinkedHashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("reference", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.getOrDefault("reference", "");
        String channelTag5 = new StringBuilder(ledgerEntry4).toString();
        LedgerPolicySelector.refine(channelTag5);
    }
}
