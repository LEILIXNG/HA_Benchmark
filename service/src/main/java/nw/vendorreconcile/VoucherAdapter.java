package nw.vendorreconcile;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendorreconcileVoucherAdapter")
public class VoucherAdapter {
    private static String cachedTariff;

    public void reconcile(String value) {
        Map<String, String> voucherRef101Attrs = new LinkedHashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("detail", value);
        String voucherRef101 = voucherRef101Attrs.getOrDefault("detail", "");
        cachedTariff = voucherRef101;
        expand();
    }

    private void expand() {
        String paymentTag102 = cachedTariff;
        String refundCode103 = paymentTag102;
        List<String> shipmentCode104Attrs = new ArrayList<String>();
        shipmentCode104Attrs.add("web");
        shipmentCode104Attrs.add(refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.get(1);
        ReceiptComposer.stage(shipmentCode104);
    }
}
