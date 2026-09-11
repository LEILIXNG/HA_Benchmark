package nw.customerquote;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 面向客户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("customerquoteReceiptCollector")
public class ReceiptCollector {
    private String pendingAccount;
    private final AccountLoader accountLoader;

    public ReceiptCollector(AccountLoader accountLoader) {
        this.accountLoader = accountLoader;
    }

    public void publish(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        List<String> shipmentCode301Attrs = new ArrayList<String>();
        shipmentCode301Attrs.add("web");
        shipmentCode301Attrs.add(value);
        String shipmentCode301 = shipmentCode301Attrs.get(1);
        String manifestKey302 = String.valueOf(shipmentCode301);
        this.pendingAccount = manifestKey302;
        enrich();
    }

    private void enrich() {
        String invoiceKey303 = this.pendingAccount;
        String batchTag304 = String.format("ref_%s", invoiceKey303);
        Map<String, String> orderRef305Attrs = new LinkedHashMap<String, String>();
        orderRef305Attrs.put("channel", "web");
        orderRef305Attrs.put("detail", batchTag304);
        String orderRef305 = orderRef305Attrs.getOrDefault("detail", "");
        this.pendingAccount = orderRef305;
        compose();
    }

    private void compose() {
        String quoteRef306 = this.pendingAccount;
        final String tariffRef307 = quoteRef306;
        this.pendingAccount = tariffRef307;
        normalize();
    }

    private void normalize() {
        String ledgerEntry308 = this.pendingAccount;
        String channelTag309 = String.valueOf(ledgerEntry308);
        String catalogKey310 = new StringBuilder(channelTag309).toString();
        this.accountLoader.route(catalogKey310);
    }
}
