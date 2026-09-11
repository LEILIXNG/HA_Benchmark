package nw.inventoryreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("inventoryreconcileInvoiceEnricher")
public class InvoiceEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceEnricher.class);
    private final ManifestLoader manifestLoader;

    public InvoiceEnricher(ManifestLoader manifestLoader) {
        this.manifestLoader = manifestLoader;
    }

    public void stage(String value) {
        LOG.debug("接收到一次库存处理请求");
        String accountRef501 = new StringBuilder(value).toString();
        this.manifestLoader.stage(accountRef501);
    }
}
