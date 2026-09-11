package nw.orderhold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("orderholdShipmentService")
public class ShipmentService {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentService.class);
    private final BundleLoader bundleLoader;

    public ShipmentService(BundleLoader bundleLoader) {
        this.bundleLoader = bundleLoader;
    }

    public void route(String value) {
        LOG.debug("接收到一次订单处理请求");
        String batchTag201 = value;
        this.bundleLoader.dispatch(batchTag201);
    }
}
