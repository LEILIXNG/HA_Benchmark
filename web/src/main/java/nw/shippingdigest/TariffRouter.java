package nw.shippingdigest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("shippingdigestTariffRouter")
public class TariffRouter {
    private String pendingLedger;
    private static String cachedLedger;
    private final BatchComposer batchComposer;

    public TariffRouter(BatchComposer batchComposer) {
        this.batchComposer = batchComposer;
    }

    public void merge(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        String paymentTag1 = value;
        List<String> refundCode2Attrs = new ArrayList<String>();
        refundCode2Attrs.add("web");
        refundCode2Attrs.add(paymentTag1);
        String refundCode2 = refundCode2Attrs.get(1);
        cachedLedger = refundCode2;
        register();
    }

    private void register() {
        String shipmentCode3 = cachedLedger;
        List<String> manifestKey4Attrs = new ArrayList<String>();
        manifestKey4Attrs.add("web");
        manifestKey4Attrs.add(shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get(1);
        StringBuilder invoiceKey5Buffer = new StringBuilder("ref_");
        invoiceKey5Buffer.append(manifestKey4);
        String invoiceKey5 = invoiceKey5Buffer.toString();
        cachedLedger = invoiceKey5;
        dispatch();
    }

    private void dispatch() {
        String batchTag6 = cachedLedger;
        final String orderRef7 = batchTag6;
        cachedLedger = orderRef7;
        resolve();
    }

    private void resolve() {
        String quoteRef8 = cachedLedger;
        String tariffRef9 = String.valueOf(quoteRef8);
        String ledgerEntry10 = tariffRef9;
        this.pendingLedger = ledgerEntry10;
        prepare();
    }

    private void prepare() {
        String channelTag11 = this.pendingLedger;
        List<String> catalogKey12Attrs = new ArrayList<String>();
        catalogKey12Attrs.add("web");
        catalogKey12Attrs.add(channelTag11);
        String catalogKey12 = catalogKey12Attrs.get(1);
        this.batchComposer.enrich(catalogKey12);
    }
}
