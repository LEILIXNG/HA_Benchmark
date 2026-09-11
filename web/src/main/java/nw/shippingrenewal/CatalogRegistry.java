package nw.shippingrenewal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRegistry.class);

    public static void dispatch(String value) {
        LOG.trace("进入发运处理环节");
        String invoiceKey301 = String.valueOf(value);
        String batchTag302 = "ref_".concat(invoiceKey301);
        RefundEvaluator.reconcile(batchTag302);
    }
}
