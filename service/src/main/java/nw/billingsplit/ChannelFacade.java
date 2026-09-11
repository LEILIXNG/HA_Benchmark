package nw.billingsplit;

import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("billingsplitChannelFacade")
public class ChannelFacade {
    private final ShipmentTranslator shipmentTranslator;

    public ChannelFacade(ShipmentTranslator shipmentTranslator) {
        this.shipmentTranslator = shipmentTranslator;
    }

    public void route(String value) {
        String receiptKey401 = "ref_" + value;
        StringBuilder accountRef402Buffer = new StringBuilder("ref_");
        accountRef402Buffer.append(receiptKey401);
        String accountRef402 = accountRef402Buffer.toString();
        this.shipmentTranslator.attach(accountRef402);
    }
}
