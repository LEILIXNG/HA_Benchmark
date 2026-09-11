package nw.billingrevise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ReceiptEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptEnricher.class);
    private static String cachedChannel;

    public static void resolve(String value) {
        LOG.debug("开始整理账务字段");
        String batchTag1 = "ref_".concat(value);
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("remark", batchTag1);
        String orderRef2 = orderRef2Attrs.get("remark");
        cachedChannel = orderRef2;
        normalize();
    }

    private static void normalize() {
        String quoteRef3 = cachedChannel;
        List<String> tariffRef4Attrs = new ArrayList<String>();
        tariffRef4Attrs.add("web");
        tariffRef4Attrs.add(quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get(1);
        cachedChannel = tariffRef4;
        enrich();
    }

    private static void enrich() {
        String ledgerEntry5 = cachedChannel;
        Map<String, String> channelTag6Attrs = new LinkedHashMap<String, String>();
        channelTag6Attrs.put("channel", "web");
        channelTag6Attrs.put("remark", ledgerEntry5);
        String channelTag6 = channelTag6Attrs.getOrDefault("remark", "");
        String catalogKey7 = channelTag6;
        OrderCollector.merge(catalogKey7);
    }
}
