package nw.accountcapture;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ShipmentBroker {

    public static void assemble(String value) {
        List<String> shipmentCode101Attrs = new ArrayList<String>();
        shipmentCode101Attrs.add("web");
        shipmentCode101Attrs.add(value);
        String shipmentCode101 = shipmentCode101Attrs.get(1);
        RefundRepository.merge(shipmentCode101);
    }
}
