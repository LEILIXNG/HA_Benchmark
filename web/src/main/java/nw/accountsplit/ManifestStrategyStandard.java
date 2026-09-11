package nw.accountsplit;

import org.springframework.stereotype.Component;

/**
 * 账户的默认处理策略。
 */
@Component("accountsplitManifestStrategyStandard")
public class ManifestStrategyStandard implements ManifestStrategy {
    private final ShipmentService shipmentService;

    public ManifestStrategyStandard(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @Override
    public void handle(String value) {
        this.shipmentService.refine(value);
    }
}
