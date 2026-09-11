package nw.ordersettle;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("ordersettleChannelTranslator")
public class ChannelTranslator {

    public void translate(String value) {
        String ledgerEntry1 = new StringBuilder(value).toString();
        Map<String, String> channelTag2Attrs = new LinkedHashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("remark", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.getOrDefault("remark", "");
        SessionRouter.merge(channelTag2);
    }
}
