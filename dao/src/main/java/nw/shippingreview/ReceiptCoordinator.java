package nw.shippingreview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ReceiptCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptCoordinator.class);

    public static void register(String value) {
        LOG.debug("开始整理发运字段");
        String refundCode201 = new StringBuilder(value).toString();
        StringBuilder shipmentCode202Buffer = new StringBuilder("ref_");
        shipmentCode202Buffer.append(refundCode201);
        String shipmentCode202 = shipmentCode202Buffer.toString();
        InvoiceComposer.translate(shipmentCode202);
    }
}
