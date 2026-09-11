package nw.vendorsettlequeue;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorsettlequeueChannelRouter")
public class ChannelRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRouter.class);
    private static String cachedOrder;

    public void stage(String value) {
        LOG.debug("开始整理供应商字段");
        String channelTag101 = new StringBuilder(value).toString();
        cachedOrder = channelTag101;
        merge();
    }

    private void merge() {
        String catalogKey102 = cachedOrder;
        String receiptKey103 = new StringBuilder(catalogKey102).toString();
        Map<String, String> accountRef104Attrs = new HashMap<String, String>();
        accountRef104Attrs.put("channel", "web");
        accountRef104Attrs.put("reference", receiptKey103);
        String accountRef104 = accountRef104Attrs.get("reference");
        InvoiceTranslator.route(accountRef104);
    }
}
