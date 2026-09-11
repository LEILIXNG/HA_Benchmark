package nw.pricinghold;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCoordinator.class);

    public static void register(String value) {
        LOG.debug("开始整理定价字段");
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.get("detail");
        String manifestKey2 = shipmentCode1;
        QuoteBuilder.expand(manifestKey2);
    }
}
