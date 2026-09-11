package nw.inventoryreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("inventoryreconcileTariffEnricher")
public class TariffEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(TariffEnricher.class);
    private static String cachedManifest;
    private final VoucherPlanSelector voucherPlanSelector;

    public TariffEnricher(VoucherPlanSelector voucherPlanSelector) {
        this.voucherPlanSelector = voucherPlanSelector;
    }

    public void publish(String value) {
        LOG.debug("接收到一次库存处理请求");
        String manifestKey101 = "ref_" + value;
        cachedManifest = manifestKey101;
        submit();
    }

    private void submit() {
        String invoiceKey102 = cachedManifest;
        String batchTag103 = "ref_" + invoiceKey102;
        String orderRef104 = "ref_".concat(batchTag103);
        this.voucherPlanSelector.dispatch(orderRef104);
    }
}
