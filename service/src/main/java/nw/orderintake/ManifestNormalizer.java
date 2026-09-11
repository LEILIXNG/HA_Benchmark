package nw.orderintake;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("orderintakeManifestNormalizer")
public class ManifestNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestNormalizer.class);
    private static String cachedOrder;
    private final LedgerAssembler ledgerAssembler;

    public ManifestNormalizer(LedgerAssembler ledgerAssembler) {
        this.ledgerAssembler = ledgerAssembler;
    }

    public void refine(String value) {
        LOG.debug("订单流程转下一环节");
        List<String> accountRef101Attrs = new ArrayList<String>();
        accountRef101Attrs.add("web");
        accountRef101Attrs.add(value);
        String accountRef101 = accountRef101Attrs.get(1);
        cachedOrder = accountRef101;
        publish();
    }

    private void publish() {
        String voucherRef102 = cachedOrder;
        String paymentTag103 = new StringBuilder(voucherRef102).toString();
        String refundCode104 = paymentTag103;
        cachedOrder = refundCode104;
        compose();
    }

    private void compose() {
        String shipmentCode105 = cachedOrder;
        String manifestKey106 = shipmentCode105;
        String invoiceKey107 = "ref_" + manifestKey106;
        this.ledgerAssembler.refine(invoiceKey107);
    }
}
