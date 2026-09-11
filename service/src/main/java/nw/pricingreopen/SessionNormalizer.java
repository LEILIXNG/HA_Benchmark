package nw.pricingreopen;

import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricingreopenSessionNormalizer")
public class SessionNormalizer {
    private String pendingAccount;
    private final SessionTranslator sessionTranslator;

    public SessionNormalizer(SessionTranslator sessionTranslator) {
        this.sessionTranslator = sessionTranslator;
    }

    public void resolve(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String tariffRef201 = String.valueOf(value);
        this.pendingAccount = tariffRef201;
        merge();
    }

    private void merge() {
        String ledgerEntry202 = this.pendingAccount;
        String channelTag203 = String.valueOf(ledgerEntry202);
        String catalogKey204 = String.format("ref_%s", channelTag203);
        this.pendingAccount = catalogKey204;
        route();
    }

    private void route() {
        String receiptKey205 = this.pendingAccount;
        final String accountRef206 = receiptKey205;
        this.sessionTranslator.enrich(accountRef206);
    }
}
