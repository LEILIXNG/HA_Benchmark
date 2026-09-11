package nw.shippingmerge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class SessionBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(SessionBuilder.class);
    private static String cachedAccount;

    public static void normalize(String value) {
        LOG.debug("开始整理发运字段");
        Map<String, String> channelTag301Attrs = new LinkedHashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("detail", value);
        String channelTag301 = channelTag301Attrs.getOrDefault("detail", "");
        List<String> catalogKey302Attrs = new ArrayList<String>();
        catalogKey302Attrs.add("web");
        catalogKey302Attrs.add(channelTag301);
        String catalogKey302 = catalogKey302Attrs.get(1);
        cachedAccount = catalogKey302;
        assemble();
    }

    private static void assemble() {
        String receiptKey303 = cachedAccount;
        Map<String, String> accountRef304Attrs = new LinkedHashMap<String, String>();
        accountRef304Attrs.put("channel", "web");
        accountRef304Attrs.put("reference", receiptKey303);
        String accountRef304 = accountRef304Attrs.getOrDefault("reference", "");
        AccountExecutor.forward(accountRef304);
    }
}
