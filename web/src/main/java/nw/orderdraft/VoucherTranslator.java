package nw.orderdraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("orderdraftVoucherTranslator")
public class VoucherTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherTranslator.class);
    private String pendingSession;
    private final BatchRegistry batchRegistry;

    public VoucherTranslator(BatchRegistry batchRegistry) {
        this.batchRegistry = batchRegistry;
    }

    public void publish(String value) {
        LOG.debug("订单流程转下一环节");
        this.translate(value);
    }

    private void translate(String value) {
        String voucherRef101 = new StringBuilder(value).toString();
        this.pendingSession = voucherRef101;
        normalize();
    }

    private void normalize() {
        String paymentTag102 = this.pendingSession;
        String refundCode103 = "ref_" + paymentTag102;
        String shipmentCode104 = refundCode103;
        this.batchRegistry.submit(shipmentCode104);
    }
}
