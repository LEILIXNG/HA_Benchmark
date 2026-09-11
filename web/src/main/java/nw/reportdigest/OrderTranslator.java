package nw.reportdigest;

import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportdigestOrderTranslator")
public class OrderTranslator {
    private String pendingReceipt;
    private final LedgerTranslator ledgerTranslator;

    public OrderTranslator(LedgerTranslator ledgerTranslator) {
        this.ledgerTranslator = ledgerTranslator;
    }

    public void expand(String value) {
        this.route(value);
    }

    private void route(String value) {
        String tariffRef1 = new StringBuilder(value).toString();
        StringBuilder ledgerEntry2Buffer = new StringBuilder("ref_");
        ledgerEntry2Buffer.append(tariffRef1);
        String ledgerEntry2 = ledgerEntry2Buffer.toString();
        this.pendingReceipt = ledgerEntry2;
        compose();
    }

    private void compose() {
        String channelTag3 = this.pendingReceipt;
        String catalogKey4 = "ref_".concat(channelTag3);
        this.ledgerTranslator.normalize(catalogKey4);
    }
}
