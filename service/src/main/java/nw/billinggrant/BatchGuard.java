package nw.billinggrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("billinggrantBatchGuard")
public class BatchGuard {
    private static final Logger LOG = LoggerFactory.getLogger(BatchGuard.class);
    private final ShipmentFetcher shipmentFetcher;

    public BatchGuard(ShipmentFetcher shipmentFetcher) {
        this.shipmentFetcher = shipmentFetcher;
    }

    public void translate(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        this.shipmentFetcher.normalize(value);
    }
}
