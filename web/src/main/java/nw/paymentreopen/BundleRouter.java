package nw.paymentreopen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("paymentreopenBundleRouter")
public class BundleRouter {
    private static final Logger LOG = LoggerFactory.getLogger(BundleRouter.class);
    private final BundleCoordinator bundleCoordinator;

    public BundleRouter(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    public void stage(String value) {
        LOG.debug("开始整理支付字段");
        String invoiceKey1 = String.format("ref_%s", value);
        this.bundleCoordinator.route(invoiceKey1);
    }
}
