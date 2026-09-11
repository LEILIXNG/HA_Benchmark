package nw.inventorybind;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ChannelNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelNormalizer.class);
    private String pendingContract;

    public static void prepare(String value) {
        LOG.debug("开始整理库存字段");
        ChannelNormalizer self = new ChannelNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String refundCode101 = String.format("ref_%s", value);
        Map<String, String> shipmentCode102Attrs = new LinkedHashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("remark", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.getOrDefault("remark", "");
        this.pendingContract = shipmentCode102;
        resolve();
    }

    private void resolve() {
        String manifestKey103 = this.pendingContract;
        final String invoiceKey104 = manifestKey103;
        String batchTag105 = "ref_" + invoiceKey104;
        ShipmentRegistry.submit(batchTag105);
    }
}
