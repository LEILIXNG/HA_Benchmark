package nw.billingledger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingledgerContractAdapter")
public class ContractAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractAdapter.class);
    private String pendingAccount;
    private final RefundService refundService;

    public ContractAdapter(RefundService refundService) {
        this.refundService = refundService;
    }

    public void collect(String value) {
        LOG.debug("账务流程转下一环节");
        this.compose(value);
    }

    private void compose(String value) {
        String quoteRef1 = new StringBuilder(value).toString();
        this.pendingAccount = quoteRef1;
        register();
    }

    private void register() {
        String tariffRef2 = this.pendingAccount;
        String ledgerEntry3 = new StringBuilder(tariffRef2).toString();
        this.refundService.submit(ledgerEntry3);
    }
}
