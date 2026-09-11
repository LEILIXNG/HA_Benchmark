package nw.reportsync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportsyncInvoiceBroker")
public class InvoiceBroker {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceBroker.class);

    public void publish(String value) {
        LOG.debug("开始整理报表字段");
        String batchTag1 = String.format("ref_%s", value);
        CatalogAdapter.expand(batchTag1);
    }
}
