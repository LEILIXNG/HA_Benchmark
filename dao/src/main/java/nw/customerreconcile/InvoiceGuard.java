package nw.customerreconcile;

import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("customerreconcileInvoiceGuard")
public class InvoiceGuard {
    private final ShipmentRepository shipmentRepository;

    public InvoiceGuard(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public void attach(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        this.shipmentRepository.reconcile(value);
    }
}
