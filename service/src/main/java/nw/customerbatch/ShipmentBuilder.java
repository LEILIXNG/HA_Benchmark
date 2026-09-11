package nw.customerbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentBuilder.class);
    private String pendingBatch;

    public static void assemble(String value) {
        LOG.debug("接收到一次客户处理请求");
        ShipmentBuilder self = new ShipmentBuilder();
        self.resolve(value);
    }

    private void resolve(String value) {
        String paymentTag201 = value;
        String refundCode202 = "ref_".concat(paymentTag201);
        this.pendingBatch = refundCode202;
        attach();
    }

    private void attach() {
        String shipmentCode203 = this.pendingBatch;
        StringBuilder manifestKey204Buffer = new StringBuilder("ref_");
        manifestKey204Buffer.append(shipmentCode203);
        String manifestKey204 = manifestKey204Buffer.toString();
        BatchLoader.forward(manifestKey204);
    }
}
