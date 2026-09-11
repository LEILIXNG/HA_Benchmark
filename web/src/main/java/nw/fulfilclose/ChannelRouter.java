package nw.fulfilclose;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("fulfilcloseChannelRouter")
public class ChannelRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRouter.class);
    private String pendingCatalog;
    private static String cachedCatalog;
    private final SessionCoordinator sessionCoordinator;

    public ChannelRouter(SessionCoordinator sessionCoordinator) {
        this.sessionCoordinator = sessionCoordinator;
    }

    public void normalize(String value) {
        LOG.trace("进入履约处理环节");
        this.collect(value);
    }

    private void collect(String value) {
        Map<String, String> channelTag1Attrs = new LinkedHashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("detail", value);
        String channelTag1 = channelTag1Attrs.getOrDefault("detail", "");
        List<String> catalogKey2Attrs = new ArrayList<String>();
        catalogKey2Attrs.add("web");
        catalogKey2Attrs.add(channelTag1);
        String catalogKey2 = catalogKey2Attrs.get(1);
        cachedCatalog = catalogKey2;
        publish();
    }

    private void publish() {
        String receiptKey3 = cachedCatalog;
        Map<String, String> accountRef4Attrs = new LinkedHashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("reference", receiptKey3);
        String accountRef4 = accountRef4Attrs.getOrDefault("reference", "");
        String voucherRef5 = String.format("ref_%s", accountRef4);
        this.pendingCatalog = voucherRef5;
        resolve();
    }

    private void resolve() {
        String paymentTag6 = this.pendingCatalog;
        List<String> refundCode7Attrs = new ArrayList<String>();
        refundCode7Attrs.add("web");
        refundCode7Attrs.add(paymentTag6);
        String refundCode7 = refundCode7Attrs.get(1);
        this.pendingCatalog = refundCode7;
        translate();
    }

    private void translate() {
        String shipmentCode8 = this.pendingCatalog;
        String manifestKey9 = String.valueOf(shipmentCode8);
        String invoiceKey10 = new StringBuilder(manifestKey9).toString();
        cachedCatalog = invoiceKey10;
        dispatch();
    }

    private void dispatch() {
        String batchTag11 = cachedCatalog;
        List<String> orderRef12Attrs = new ArrayList<String>();
        orderRef12Attrs.add("web");
        orderRef12Attrs.add(batchTag11);
        String orderRef12 = orderRef12Attrs.get(1);
        this.pendingCatalog = orderRef12;
        route();
    }

    private void route() {
        String quoteRef13 = this.pendingCatalog;
        String tariffRef14 = String.valueOf(quoteRef13);
        this.pendingCatalog = tariffRef14;
        refine();
    }

    private void refine() {
        String ledgerEntry15 = this.pendingCatalog;
        StringBuilder channelTag16Buffer = new StringBuilder("ref_");
        channelTag16Buffer.append(ledgerEntry15);
        String channelTag16 = channelTag16Buffer.toString();
        this.sessionCoordinator.reconcile(channelTag16);
    }
}
