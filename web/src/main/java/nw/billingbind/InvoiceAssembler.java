package nw.billingbind;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("billingbindInvoiceAssembler")
public class InvoiceAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceAssembler.class);
    private final QuotePlanSelector quotePlanSelector;

    public InvoiceAssembler(QuotePlanSelector quotePlanSelector) {
        this.quotePlanSelector = quotePlanSelector;
    }

    public void reconcile(String value) {
        LOG.debug("开始整理账务字段");
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        this.quotePlanSelector.route(orderRef1);
    }
}
