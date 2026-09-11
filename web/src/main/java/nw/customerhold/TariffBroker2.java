package nw.customerhold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffBroker2 {
    private static final Logger LOG = LoggerFactory.getLogger(TariffBroker2.class);
    private String pendingQuote;
    private static String cachedQuote;

    public static void compose(String value) {
        LOG.debug("客户流程转下一环节");
        TariffBroker2 self = new TariffBroker2();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String batchTag101 = "ref_".concat(value);
        cachedQuote = batchTag101;
        translate();
    }

    private void translate() {
        String orderRef102 = cachedQuote;
        String quoteRef103 = new StringBuilder(orderRef102).toString();
        this.pendingQuote = quoteRef103;
        attach();
    }

    private void attach() {
        String tariffRef104 = this.pendingQuote;
        StringBuilder ledgerEntry105Buffer = new StringBuilder("ref_");
        ledgerEntry105Buffer.append(tariffRef104);
        String ledgerEntry105 = ledgerEntry105Buffer.toString();
        TariffBroker.route(ledgerEntry105);
    }
}
