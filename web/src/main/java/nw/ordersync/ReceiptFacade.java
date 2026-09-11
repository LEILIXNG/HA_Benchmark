package nw.ordersync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("ordersyncReceiptFacade")
public class ReceiptFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptFacade.class);
    private String pendingQuote;
    private static String cachedQuote;
    private final BatchRuleSelector batchRuleSelector;

    public ReceiptFacade(BatchRuleSelector batchRuleSelector) {
        this.batchRuleSelector = batchRuleSelector;
    }

    public void compose(String value) {
        LOG.debug("开始整理订单字段");
        this.collect(value);
    }

    private void collect(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("detail", value);
        String receiptKey1 = receiptKey1Attrs.get("detail");
        this.pendingQuote = receiptKey1;
        submit();
    }

    private void submit() {
        String accountRef2 = this.pendingQuote;
        String voucherRef3 = "ref_" + accountRef2;
        this.pendingQuote = voucherRef3;
        forward();
    }

    private void forward() {
        String paymentTag4 = this.pendingQuote;
        List<String> refundCode5Attrs = new ArrayList<String>();
        refundCode5Attrs.add("web");
        refundCode5Attrs.add(paymentTag4);
        String refundCode5 = refundCode5Attrs.get(1);
        cachedQuote = refundCode5;
        refine();
    }

    private void refine() {
        String shipmentCode6 = cachedQuote;
        String manifestKey7 = shipmentCode6;
        String invoiceKey8 = "ref_" + manifestKey7;
        this.batchRuleSelector.publish(invoiceKey8);
    }
}
