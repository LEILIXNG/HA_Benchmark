package nw.pricinggrant;

import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricinggrantChannelFacade")
public class ChannelFacade {
    private final ShipmentNormalizer shipmentNormalizer;

    public ChannelFacade(ShipmentNormalizer shipmentNormalizer) {
        this.shipmentNormalizer = shipmentNormalizer;
    }

    public void enrich(String value) {
        String catalogKey101 = String.format("ref_%s", value);
        String receiptKey102 = "ref_".concat(catalogKey101);
        this.shipmentNormalizer.translate(receiptKey102);
    }
}
