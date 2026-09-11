package nw.billingintake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteCoordinator.class);
    private String pendingInvoice;

    public static void prepare(String value) {
        LOG.trace("进入账务处理环节");
        QuoteCoordinator self = new QuoteCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        final String catalogKey301 = value;
        this.pendingInvoice = catalogKey301;
        expand();
    }

    private void expand() {
        String receiptKey302 = this.pendingInvoice;
        final String accountRef303 = receiptKey302;
        InvoiceGateway.translate(accountRef303);
    }
}
