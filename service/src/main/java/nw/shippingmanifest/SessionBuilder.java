package nw.shippingmanifest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class SessionBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(SessionBuilder.class);
    private static String cachedShipment;

    public static void refine(String value) {
        LOG.debug("发运流程转下一环节");
        List<String> receiptKey201Attrs = new ArrayList<String>();
        receiptKey201Attrs.add("web");
        receiptKey201Attrs.add(value);
        String receiptKey201 = receiptKey201Attrs.get(1);
        Map<String, String> accountRef202Attrs = new HashMap<String, String>();
        accountRef202Attrs.put("channel", "web");
        accountRef202Attrs.put("remark", receiptKey201);
        String accountRef202 = accountRef202Attrs.get("remark");
        cachedShipment = accountRef202;
        translate();
    }

    private static void translate() {
        String voucherRef203 = cachedShipment;
        String paymentTag204 = voucherRef203;
        List<String> refundCode205Attrs = new ArrayList<String>();
        refundCode205Attrs.add("web");
        refundCode205Attrs.add(paymentTag204);
        String refundCode205 = refundCode205Attrs.get(1);
        ManifestRouter.dispatch(refundCode205);
    }
}
