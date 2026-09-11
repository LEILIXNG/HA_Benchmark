package nw.reporttransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class QuoteNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteNormalizer.class);
    private String pendingInvoice;

    public static void assemble(String value) {
        LOG.debug("接收到一次报表处理请求");
        QuoteNormalizer self = new QuoteNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String channelTag201 = String.format("ref_%s", value);
        String catalogKey202 = "ref_".concat(channelTag201);
        this.pendingInvoice = catalogKey202;
        route();
    }

    private void route() {
        String receiptKey203 = this.pendingInvoice;
        final String accountRef204 = receiptKey203;
        ContractPlanSelector.expand(accountRef204);
    }
}
