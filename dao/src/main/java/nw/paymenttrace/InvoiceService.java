package nw.paymenttrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("paymenttraceInvoiceService")
public class InvoiceService {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceService.class);
    private String pendingSession;
    private static String cachedSession;
    private final SessionEvaluator sessionEvaluator;

    public InvoiceService(SessionEvaluator sessionEvaluator) {
        this.sessionEvaluator = sessionEvaluator;
    }

    public void enrich(String value) {
        LOG.debug("开始整理支付字段");
        this.prepare(value);
    }

    private void prepare(String value) {
        String invoiceKey401 = value;
        cachedSession = invoiceKey401;
        dispatch();
    }

    private void dispatch() {
        String batchTag402 = cachedSession;
        String orderRef403 = String.format("ref_%s", batchTag402);
        this.pendingSession = orderRef403;
        stage();
    }

    private void stage() {
        String quoteRef404 = this.pendingSession;
        String tariffRef405 = "ref_" + quoteRef404;
        this.sessionEvaluator.publish(tariffRef405);
    }
}
