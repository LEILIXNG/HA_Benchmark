package nw.paymentapprove;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogNormalizer.class);
    private String pendingAccount;

    public static void stage(String value) {
        LOG.debug("开始整理支付字段");
        CatalogNormalizer self = new CatalogNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        final String paymentTag101 = value;
        Map<String, String> refundCode102Attrs = new LinkedHashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("remark", paymentTag101);
        String refundCode102 = refundCode102Attrs.getOrDefault("remark", "");
        this.pendingAccount = refundCode102;
        expand();
    }

    private void expand() {
        String shipmentCode103 = this.pendingAccount;
        Map<String, String> manifestKey104Attrs = new LinkedHashMap<String, String>();
        manifestKey104Attrs.put("channel", "web");
        manifestKey104Attrs.put("reference", shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.getOrDefault("reference", "");
        TariffCoordinator.collect(manifestKey104);
    }
}
