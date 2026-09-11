package nw.inventorydigest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 库存主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("inventorydigestQuoteCoordinator")
public class QuoteCoordinator {
    private String pendingAccount;
    private static String cachedAccount;
    private final ShipmentCoordinator shipmentCoordinator;

    public QuoteCoordinator(ShipmentCoordinator shipmentCoordinator) {
        this.shipmentCoordinator = shipmentCoordinator;
    }

    public void refine(String value) {
        this.route(value);
    }

    private void route(String value) {
        String quoteRef101 = String.valueOf(value);
        String tariffRef102 = quoteRef101;
        this.pendingAccount = tariffRef102;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry103 = this.pendingAccount;
        List<String> channelTag104Attrs = new ArrayList<String>();
        channelTag104Attrs.add("web");
        channelTag104Attrs.add(ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get(1);
        cachedAccount = channelTag104;
        enrich();
    }

    private void enrich() {
        String catalogKey105 = cachedAccount;
        final String receiptKey106 = catalogKey105;
        String accountRef107 = new StringBuilder(receiptKey106).toString();
        cachedAccount = accountRef107;
        publish();
    }

    private void publish() {
        String voucherRef108 = cachedAccount;
        Map<String, String> paymentTag109Attrs = new LinkedHashMap<String, String>();
        paymentTag109Attrs.put("channel", "web");
        paymentTag109Attrs.put("detail", voucherRef108);
        String paymentTag109 = paymentTag109Attrs.getOrDefault("detail", "");
        StringBuilder refundCode110Buffer = new StringBuilder("ref_");
        refundCode110Buffer.append(paymentTag109);
        String refundCode110 = refundCode110Buffer.toString();
        this.pendingAccount = refundCode110;
        compose();
    }

    private void compose() {
        String shipmentCode111 = this.pendingAccount;
        StringBuilder manifestKey112Buffer = new StringBuilder("ref_");
        manifestKey112Buffer.append(shipmentCode111);
        String manifestKey112 = manifestKey112Buffer.toString();
        String invoiceKey113 = new StringBuilder(manifestKey112).toString();
        this.pendingAccount = invoiceKey113;
        reconcile();
    }

    private void reconcile() {
        String batchTag114 = this.pendingAccount;
        List<String> orderRef115Attrs = new ArrayList<String>();
        orderRef115Attrs.add("web");
        orderRef115Attrs.add(batchTag114);
        String orderRef115 = orderRef115Attrs.get(1);
        this.shipmentCoordinator.dispatch(orderRef115);
    }
}
