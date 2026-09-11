package nw.catalogdigest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ContractEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEnricher.class);

    public static void prepare(String value) {
        LOG.trace("进入商品处理环节");
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("detail", value);
        String refundCode401 = refundCode401Attrs.get("detail");
        Map<String, String> shipmentCode402Attrs = new LinkedHashMap<String, String>();
        shipmentCode402Attrs.put("channel", "web");
        shipmentCode402Attrs.put("remark", refundCode401);
        String shipmentCode402 = shipmentCode402Attrs.getOrDefault("remark", "");
        VoucherGuard.forward(shipmentCode402);
    }
}
