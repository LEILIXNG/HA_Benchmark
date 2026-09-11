package nw.inventoryintake;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ContractEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEnricher.class);

    public static void reconcile(String value) {
        LOG.debug("库存流程转下一环节");
        Map<String, String> shipmentCode301Attrs = new LinkedHashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("detail", value);
        String shipmentCode301 = shipmentCode301Attrs.getOrDefault("detail", "");
        final String manifestKey302 = shipmentCode301;
        OrderCoordinator.forward(manifestKey302);
    }
}
