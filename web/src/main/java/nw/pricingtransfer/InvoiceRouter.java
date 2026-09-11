package nw.pricingtransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingtransferInvoiceRouter")
public class InvoiceRouter {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceRouter.class);
    private final QuoteCoordinator quoteCoordinator;

    public InvoiceRouter(QuoteCoordinator quoteCoordinator) {
        this.quoteCoordinator = quoteCoordinator;
    }

    public void publish(String value) {
        LOG.debug("开始整理定价字段");
        String refundCode101 = String.format("ref_%s", value);
        this.quoteCoordinator.assemble(refundCode101);
    }
}
