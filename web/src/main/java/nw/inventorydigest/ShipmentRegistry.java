package nw.inventorydigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("inventorydigestShipmentRegistry")
public class ShipmentRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRegistry.class);
    private static String cachedAccount;
    private final QuoteCoordinator quoteCoordinator;

    public ShipmentRegistry(QuoteCoordinator quoteCoordinator) {
        this.quoteCoordinator = quoteCoordinator;
    }

    public void compose(String value) {
        LOG.debug("开始整理库存字段");
        StringBuilder receiptKey1Buffer = new StringBuilder("ref_");
        receiptKey1Buffer.append(value);
        String receiptKey1 = receiptKey1Buffer.toString();
        String accountRef2 = new StringBuilder(receiptKey1).toString();
        cachedAccount = accountRef2;
        reconcile();
    }

    private void reconcile() {
        String voucherRef3 = cachedAccount;
        String paymentTag4 = String.format("ref_%s", voucherRef3);
        String refundCode5 = "ref_".concat(paymentTag4);
        this.quoteCoordinator.refine(refundCode5);
    }
}
