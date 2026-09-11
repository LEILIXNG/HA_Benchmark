package nw.catalogbind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向商品场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("catalogbindShipmentRouter")
public class ShipmentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRouter.class);
    private String pendingTariff;
    private final InvoiceValidator invoiceValidator;

    public ShipmentRouter(InvoiceValidator invoiceValidator) {
        this.invoiceValidator = invoiceValidator;
    }

    public void attach(String value) {
        LOG.debug("开始整理商品字段");
        this.forward(value);
    }

    private void forward(String value) {
        String shipmentCode201 = String.format("ref_%s", value);
        String manifestKey202 = "ref_".concat(shipmentCode201);
        this.pendingTariff = manifestKey202;
        refine();
    }

    private void refine() {
        String invoiceKey203 = this.pendingTariff;
        StringBuilder batchTag204Buffer = new StringBuilder("ref_");
        batchTag204Buffer.append(invoiceKey203);
        String batchTag204 = batchTag204Buffer.toString();
        String orderRef205 = "ref_" + batchTag204;
        this.invoiceValidator.attach(orderRef205);
    }
}
