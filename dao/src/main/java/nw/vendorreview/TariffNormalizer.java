package nw.vendorreview;

import org.springframework.stereotype.Repository;

/**
 * 供应商主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("vendorreviewTariffNormalizer")
public class TariffNormalizer {
    private final ShipmentGuard shipmentGuard;

    public TariffNormalizer(ShipmentGuard shipmentGuard) {
        this.shipmentGuard = shipmentGuard;
    }

    public void submit(String value) {
        String invoiceKey401 = new StringBuilder(value).toString();
        this.shipmentGuard.compose(invoiceKey401);
    }
}
