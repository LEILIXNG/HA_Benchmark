package nw.fulfilreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向履约场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfilreconcileBundleCoordinator")
public class BundleCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator.class);
    private final VoucherStrategySelector voucherStrategySelector;

    public BundleCoordinator(VoucherStrategySelector voucherStrategySelector) {
        this.voucherStrategySelector = voucherStrategySelector;
    }

    public void publish(String value) {
        LOG.debug("履约流程转下一环节");
        this.voucherStrategySelector.compose(value);
    }
}
