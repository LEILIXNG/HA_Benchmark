package nw.shippingbind;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("shippingbindSessionRouter")
public class SessionRouter {
    private static final Logger LOG = LoggerFactory.getLogger(SessionRouter.class);
    private final VoucherStrategySelector voucherStrategySelector;

    public SessionRouter(VoucherStrategySelector voucherStrategySelector) {
        this.voucherStrategySelector = voucherStrategySelector;
    }

    public void dispatch(String value) {
        LOG.debug("发运流程转下一环节");
        Map<String, String> shipmentCode201Attrs = new LinkedHashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("detail", value);
        String shipmentCode201 = shipmentCode201Attrs.getOrDefault("detail", "");
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("remark", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("remark");
        this.voucherStrategySelector.stage(manifestKey202);
    }
}
