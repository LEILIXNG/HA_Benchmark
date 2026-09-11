package nw.accountsettlequeue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("accountsettlequeueBundleBroker")
public class BundleBroker {
    private static String cachedRefund;
    private final ManifestFacade manifestFacade;

    public BundleBroker(ManifestFacade manifestFacade) {
        this.manifestFacade = manifestFacade;
    }

    public void translate(String value) {
        List<String> accountRef1Attrs = new ArrayList<String>();
        accountRef1Attrs.add("web");
        accountRef1Attrs.add(value);
        String accountRef1 = accountRef1Attrs.get(1);
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("remark", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("remark");
        cachedRefund = voucherRef2;
        collect();
    }

    private void collect() {
        String paymentTag3 = cachedRefund;
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("reference", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("reference");
        StringBuilder shipmentCode5Buffer = new StringBuilder("ref_");
        shipmentCode5Buffer.append(refundCode4);
        String shipmentCode5 = shipmentCode5Buffer.toString();
        cachedRefund = shipmentCode5;
        route();
    }

    private void route() {
        String manifestKey6 = cachedRefund;
        String invoiceKey7 = new StringBuilder(manifestKey6).toString();
        String batchTag8 = String.valueOf(invoiceKey7);
        this.manifestFacade.forward(batchTag8);
    }
}
