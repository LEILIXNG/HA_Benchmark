package nw.shippingledger;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("shippingledgerShipmentRouter")
public class ShipmentRouter {
    private final ChannelBuilder channelBuilder;

    public ShipmentRouter(ChannelBuilder channelBuilder) {
        this.channelBuilder = channelBuilder;
    }

    public void normalize(String value) {
        List<String> shipmentCode101Attrs = new ArrayList<String>();
        shipmentCode101Attrs.add("web");
        shipmentCode101Attrs.add(value);
        String shipmentCode101 = shipmentCode101Attrs.get(1);
        String manifestKey102 = new StringBuilder(shipmentCode101).toString();
        this.channelBuilder.stage(manifestKey102);
    }
}
