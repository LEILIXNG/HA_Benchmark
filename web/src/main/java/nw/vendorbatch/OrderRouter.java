package nw.vendorbatch;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorbatchOrderRouter")
public class OrderRouter {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRouter.class);
    private String pendingLedger;
    private final RefundAssembler refundAssembler;

    public OrderRouter(RefundAssembler refundAssembler) {
        this.refundAssembler = refundAssembler;
    }

    public void dispatch(String value) {
        LOG.debug("供应商流程转下一环节");
        this.route(value);
    }

    private void route(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("detail", value);
        String paymentTag1 = paymentTag1Attrs.get("detail");
        this.pendingLedger = paymentTag1;
        stage();
    }

    private void stage() {
        String refundCode2 = this.pendingLedger;
        String shipmentCode3 = String.valueOf(refundCode2);
        String manifestKey4 = "ref_" + shipmentCode3;
        this.pendingLedger = manifestKey4;
        prepare();
    }

    private void prepare() {
        String invoiceKey5 = this.pendingLedger;
        final String batchTag6 = invoiceKey5;
        String orderRef7 = new StringBuilder(batchTag6).toString();
        this.pendingLedger = orderRef7;
        compose();
    }

    private void compose() {
        String quoteRef8 = this.pendingLedger;
        String tariffRef9 = String.format("ref_%s", quoteRef8);
        String ledgerEntry10 = "ref_".concat(tariffRef9);
        this.refundAssembler.forward(ledgerEntry10);
    }
}
