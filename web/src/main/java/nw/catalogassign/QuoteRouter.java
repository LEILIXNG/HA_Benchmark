package nw.catalogassign;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteRouter {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteRouter.class);
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void normalize(String value) {
        LOG.debug("接收到一次商品处理请求");
        QuoteRouter self = new QuoteRouter();
        self.publish(value);
    }

    private void publish(String value) {
        String manifestKey101 = "ref_" + value;
        cachedCatalog = manifestKey101;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey102 = cachedCatalog;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("note", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("note");
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("reference", batchTag103);
        String orderRef104 = orderRef104Attrs.get("reference");
        this.pendingCatalog = orderRef104;
        stage();
    }

    private void stage() {
        String quoteRef105 = this.pendingCatalog;
        String tariffRef106 = new StringBuilder(quoteRef105).toString();
        cachedCatalog = tariffRef106;
        expand();
    }

    private void expand() {
        String ledgerEntry107 = cachedCatalog;
        String channelTag108 = "ref_" + ledgerEntry107;
        String catalogKey109 = String.valueOf(channelTag108);
        CatalogGateway.submit(catalogKey109);
    }
}
