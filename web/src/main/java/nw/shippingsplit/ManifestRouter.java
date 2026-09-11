package nw.shippingsplit;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("shippingsplitManifestRouter")
public class ManifestRouter {
    private static String cachedContract;
    private final VoucherFacade voucherFacade;

    public ManifestRouter(VoucherFacade voucherFacade) {
        this.voucherFacade = voucherFacade;
    }

    public void enrich(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.get("detail");
        cachedContract = refundCode101;
        register();
    }

    private void register() {
        String shipmentCode102 = cachedContract;
        String manifestKey103 = new StringBuilder(shipmentCode102).toString();
        this.voucherFacade.dispatch(manifestKey103);
    }
}
