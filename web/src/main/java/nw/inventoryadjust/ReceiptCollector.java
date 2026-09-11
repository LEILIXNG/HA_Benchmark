package nw.inventoryadjust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ReceiptCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptCollector.class);
    private String pendingShipment;
    private static String cachedShipment;

    public static void collect(String value) {
        LOG.trace("进入库存处理环节");
        ReceiptCollector self = new ReceiptCollector();
        self.refine(value);
    }

    private void refine(String value) {
        final String orderRef1 = value;
        cachedShipment = orderRef1;
        reconcile();
    }

    private void reconcile() {
        String quoteRef2 = cachedShipment;
        List<String> tariffRef3Attrs = new ArrayList<String>();
        tariffRef3Attrs.add("web");
        tariffRef3Attrs.add(quoteRef2);
        String tariffRef3 = tariffRef3Attrs.get(1);
        this.pendingShipment = tariffRef3;
        stage();
    }

    private void stage() {
        String ledgerEntry4 = this.pendingShipment;
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("detail", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("detail");
        StringBuilder catalogKey6Buffer = new StringBuilder("ref_");
        catalogKey6Buffer.append(channelTag5);
        String catalogKey6 = catalogKey6Buffer.toString();
        this.pendingShipment = catalogKey6;
        resolve();
    }

    private void resolve() {
        String receiptKey7 = this.pendingShipment;
        String accountRef8 = String.format("ref_%s", receiptKey7);
        String voucherRef9 = new StringBuilder(accountRef8).toString();
        QuoteTranslator.stage(voucherRef9);
    }
}
