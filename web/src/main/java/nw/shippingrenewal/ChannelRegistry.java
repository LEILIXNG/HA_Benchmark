package nw.shippingrenewal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向发运场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRegistry.class);
    private static String cachedRefund;

    public static void stage(String value) {
        LOG.trace("进入发运处理环节");
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("detail", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("detail");
        Map<String, String> channelTag202Attrs = new LinkedHashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("remark", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.getOrDefault("remark", "");
        cachedRefund = channelTag202;
        merge();
    }

    private static void merge() {
        String catalogKey203 = cachedRefund;
        Map<String, String> receiptKey204Attrs = new LinkedHashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("reference", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.getOrDefault("reference", "");
        CatalogRegistry.dispatch(receiptKey204);
    }
}
