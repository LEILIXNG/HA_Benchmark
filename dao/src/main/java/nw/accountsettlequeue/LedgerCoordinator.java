package nw.accountsettlequeue;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("accountsettlequeueLedgerCoordinator")
public class LedgerCoordinator {
    private String pendingRefund;
    private final LedgerStrategySelector ledgerStrategySelector;

    public LedgerCoordinator(LedgerStrategySelector ledgerStrategySelector) {
        this.ledgerStrategySelector = ledgerStrategySelector;
    }

    public void normalize(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        final String manifestKey201 = value;
        this.pendingRefund = manifestKey201;
        register();
    }

    private void register() {
        String invoiceKey202 = this.pendingRefund;
        String batchTag203 = "ref_" + invoiceKey202;
        this.pendingRefund = batchTag203;
        submit();
    }

    private void submit() {
        String orderRef204 = this.pendingRefund;
        List<String> quoteRef205Attrs = new ArrayList<String>();
        quoteRef205Attrs.add("web");
        quoteRef205Attrs.add(orderRef204);
        String quoteRef205 = quoteRef205Attrs.get(1);
        List<String> tariffRef206Attrs = new ArrayList<String>();
        tariffRef206Attrs.add("web");
        tariffRef206Attrs.add(quoteRef205);
        String tariffRef206 = tariffRef206Attrs.get(1);
        this.ledgerStrategySelector.normalize(tariffRef206);
    }
}
