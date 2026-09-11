package nw.orderexport;

import org.springframework.stereotype.Repository;

/**
 * 订单主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("orderexportBatchRouter")
public class BatchRouter {
    private final ShipmentScreen shipmentScreen;

    public BatchRouter(ShipmentScreen shipmentScreen) {
        this.shipmentScreen = shipmentScreen;
    }

    public void register(String value) {
        final String tariffRef301 = value;
        this.shipmentScreen.resolve(tariffRef301);
    }
}
