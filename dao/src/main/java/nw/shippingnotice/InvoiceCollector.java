package nw.shippingnotice;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class InvoiceCollector {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceCollector.class);

    public static void collect(String value) {
        LOG.trace("进入发运处理环节");
        String invoiceKey401 = new StringBuilder(value).toString();
        Map<String, String> batchTag402Attrs = new HashMap<String, String>();
        batchTag402Attrs.put("channel", "web");
        batchTag402Attrs.put("remark", invoiceKey401);
        String batchTag402 = batchTag402Attrs.get("remark");
        ContractEvaluator.assemble(batchTag402);
    }
}
