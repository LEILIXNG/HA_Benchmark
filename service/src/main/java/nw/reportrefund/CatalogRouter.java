package nw.reportrefund;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class CatalogRouter {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRouter.class);
    private static String cachedTariff;

    public static void stage(String value) {
        LOG.debug("接收到一次报表处理请求");
        String shipmentCode101 = new StringBuilder(value).toString();
        String manifestKey102 = "ref_".concat(shipmentCode101);
        cachedTariff = manifestKey102;
        resolve();
    }

    private static void resolve() {
        String invoiceKey103 = cachedTariff;
        Map<String, String> batchTag104Attrs = new LinkedHashMap<String, String>();
        batchTag104Attrs.put("channel", "web");
        batchTag104Attrs.put("reference", invoiceKey103);
        String batchTag104 = batchTag104Attrs.getOrDefault("reference", "");
        ReceiptAdapter.translate(batchTag104);
    }
}
