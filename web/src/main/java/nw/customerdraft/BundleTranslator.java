package nw.customerdraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customerdraftBundleTranslator")
public class BundleTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleTranslator.class);
    private final OrderCoordinator orderCoordinator;

    public BundleTranslator(OrderCoordinator orderCoordinator) {
        this.orderCoordinator = orderCoordinator;
    }

    public void enrich(String value) {
        LOG.debug("开始整理客户字段");
        final String refundCode101 = value;
        String shipmentCode102 = "ref_" + refundCode101;
        this.orderCoordinator.attach(shipmentCode102);
    }
}
