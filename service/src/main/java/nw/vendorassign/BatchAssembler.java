package nw.vendorassign;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BatchAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(BatchAssembler.class);

    public static void reconcile(String value) {
        LOG.debug("开始整理供应商字段");
        String catalogKey301 = String.valueOf(value);
        List<String> receiptKey302Attrs = new ArrayList<String>();
        receiptKey302Attrs.add("web");
        receiptKey302Attrs.add(catalogKey301);
        String receiptKey302 = receiptKey302Attrs.get(1);
        CatalogGuard.route(receiptKey302);
    }
}
