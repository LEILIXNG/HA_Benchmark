package nw.accountverify;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountverifyManifestFacade")
public class ManifestFacade {
    private final BundleFacade bundleFacade;

    public ManifestFacade(BundleFacade bundleFacade) {
        this.bundleFacade = bundleFacade;
    }

    public void route(String value) {
        String paymentTag201 = String.valueOf(value);
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("remark", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("remark");
        this.bundleFacade.enrich(refundCode202);
    }
}
