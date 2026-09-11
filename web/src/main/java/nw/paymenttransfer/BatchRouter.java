package nw.paymenttransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("paymenttransferBatchRouter")
public class BatchRouter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRouter.class);
    private String pendingInvoice;
    private final SessionTranslator sessionTranslator;

    public BatchRouter(SessionTranslator sessionTranslator) {
        this.sessionTranslator = sessionTranslator;
    }

    public void submit(String value) {
        LOG.debug("支付流程转下一环节");
        this.resolve(value);
    }

    private void resolve(String value) {
        String channelTag1 = String.format("ref_%s", value);
        String catalogKey2 = String.valueOf(channelTag1);
        this.pendingInvoice = catalogKey2;
        refine();
    }

    private void refine() {
        String receiptKey3 = this.pendingInvoice;
        StringBuilder accountRef4Buffer = new StringBuilder("ref_");
        accountRef4Buffer.append(receiptKey3);
        String accountRef4 = accountRef4Buffer.toString();
        final String voucherRef5 = accountRef4;
        this.sessionTranslator.publish(voucherRef5);
    }
}
