package nw.vendorverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ShipmentEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentEnricher.class);

    public static void forward(String value) {
        LOG.debug("供应商流程转下一环节");
        final String voucherRef201 = value;
        PaymentFilter.prepare(voucherRef201);
    }
}
