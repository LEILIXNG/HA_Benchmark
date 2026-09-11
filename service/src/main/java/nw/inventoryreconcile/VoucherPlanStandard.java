package nw.inventoryreconcile;

import org.springframework.stereotype.Service;

/**
 * 库存的默认处理策略。
 */
@Service("inventoryreconcileVoucherPlanStandard")
public class VoucherPlanStandard implements VoucherPlan {
    private final ShipmentService shipmentService;

    public VoucherPlanStandard(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @Override
    public void handle(String value) {
        this.shipmentService.collect(value);
    }
}
