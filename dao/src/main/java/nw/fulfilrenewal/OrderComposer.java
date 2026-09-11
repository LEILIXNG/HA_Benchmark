package nw.fulfilrenewal;

import java.util.HashMap;
import java.util.Map;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class OrderComposer {

    public static void forward(String value) {
        String refundCode301 = String.valueOf(value);
        Map<String, String> shipmentCode302Attrs = new HashMap<String, String>();
        shipmentCode302Attrs.put("channel", "web");
        shipmentCode302Attrs.put("remark", refundCode301);
        String shipmentCode302 = shipmentCode302Attrs.get("remark");
        ContractRepository.expand(shipmentCode302);
    }
}
