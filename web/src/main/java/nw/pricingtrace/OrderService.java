package nw.pricingtrace;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingtraceOrderService")
public class OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
    private String pendingTariff;
    private final VoucherNormalizer voucherNormalizer;

    public OrderService(VoucherNormalizer voucherNormalizer) {
        this.voucherNormalizer = voucherNormalizer;
    }

    public void expand(String value) {
        LOG.debug("定价流程转下一环节");
        this.attach(value);
    }

    private void attach(String value) {
        Map<String, String> batchTag101Attrs = new LinkedHashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("detail", value);
        String batchTag101 = batchTag101Attrs.getOrDefault("detail", "");
        String orderRef102 = "ref_".concat(batchTag101);
        this.pendingTariff = orderRef102;
        merge();
    }

    private void merge() {
        String quoteRef103 = this.pendingTariff;
        StringBuilder tariffRef104Buffer = new StringBuilder("ref_");
        tariffRef104Buffer.append(quoteRef103);
        String tariffRef104 = tariffRef104Buffer.toString();
        this.pendingTariff = tariffRef104;
        assemble();
    }

    private void assemble() {
        String ledgerEntry105 = this.pendingTariff;
        String channelTag106 = ledgerEntry105;
        this.voucherNormalizer.forward(channelTag106);
    }
}
