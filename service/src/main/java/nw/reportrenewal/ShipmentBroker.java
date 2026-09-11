package nw.reportrenewal;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("reportrenewalShipmentBroker")
public class ShipmentBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentBroker.class);
    private final ReceiptBroker receiptBroker;

    public ShipmentBroker(ReceiptBroker receiptBroker) {
        this.receiptBroker = receiptBroker;
    }

    public void assemble(String value) {
        LOG.trace("进入报表处理环节");
        List<String> refundCode101Attrs = new ArrayList<String>();
        refundCode101Attrs.add("web");
        refundCode101Attrs.add(value);
        String refundCode101 = refundCode101Attrs.get(1);
        List<String> shipmentCode102Attrs = new ArrayList<String>();
        shipmentCode102Attrs.add("web");
        shipmentCode102Attrs.add(refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get(1);
        this.receiptBroker.route(shipmentCode102);
    }
}
