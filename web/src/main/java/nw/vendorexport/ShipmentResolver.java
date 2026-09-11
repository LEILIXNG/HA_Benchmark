package nw.vendorexport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorexportShipmentResolver")
public class ShipmentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentResolver.class);
    private final BundleCoordinator bundleCoordinator;

    public ShipmentResolver(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    public void stage(String value) {
        LOG.debug("开始整理供应商字段");
        final String refundCode1 = value;
        this.bundleCoordinator.resolve(refundCode1);
    }
}
