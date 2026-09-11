package nw.paymentsplit;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("paymentsplitVoucherAdapter")
public class VoucherAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAdapter.class);
    private final LedgerCoordinator ledgerCoordinator;

    public VoucherAdapter(LedgerCoordinator ledgerCoordinator) {
        this.ledgerCoordinator = ledgerCoordinator;
    }

    public void prepare(String value) {
        LOG.trace("进入支付处理环节");
        Map<String, String> paymentTag401Attrs = new LinkedHashMap<String, String>();
        paymentTag401Attrs.put("channel", "web");
        paymentTag401Attrs.put("detail", value);
        String paymentTag401 = paymentTag401Attrs.getOrDefault("detail", "");
        this.ledgerCoordinator.publish(paymentTag401);
    }
}
