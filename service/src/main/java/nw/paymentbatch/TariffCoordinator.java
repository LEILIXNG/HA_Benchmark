package nw.paymentbatch;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("paymentbatchTariffCoordinator")
public class TariffCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(TariffCoordinator.class);

    public void stage(String value) {
        LOG.debug("支付流程转下一环节");
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("detail", value);
        String voucherRef301 = voucherRef301Attrs.get("detail");
        Map<String, String> paymentTag302Attrs = new LinkedHashMap<String, String>();
        paymentTag302Attrs.put("channel", "web");
        paymentTag302Attrs.put("remark", voucherRef301);
        String paymentTag302 = paymentTag302Attrs.getOrDefault("remark", "");
        ReceiptEvaluator.attach(paymentTag302);
    }
}
