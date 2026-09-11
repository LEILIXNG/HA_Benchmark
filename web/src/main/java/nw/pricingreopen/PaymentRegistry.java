package nw.pricingreopen;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingreopenPaymentRegistry")
public class PaymentRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentRegistry.class);
    private final LedgerEnricher ledgerEnricher;

    public PaymentRegistry(LedgerEnricher ledgerEnricher) {
        this.ledgerEnricher = ledgerEnricher;
    }

    public void forward(String value) {
        LOG.debug("接收到一次定价处理请求");
        String manifestKey1 = "ref_".concat(value);
        List<String> invoiceKey2Attrs = new ArrayList<String>();
        invoiceKey2Attrs.add("web");
        invoiceKey2Attrs.add(manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get(1);
        this.ledgerEnricher.submit(invoiceKey2);
    }
}
