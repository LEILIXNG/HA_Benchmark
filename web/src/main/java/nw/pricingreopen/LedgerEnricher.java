package nw.pricingreopen;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("pricingreopenLedgerEnricher")
public class LedgerEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerEnricher.class);
    private static String cachedAccount;
    private final SessionNormalizer sessionNormalizer;

    public LedgerEnricher(SessionNormalizer sessionNormalizer) {
        this.sessionNormalizer = sessionNormalizer;
    }

    public void submit(String value) {
        LOG.debug("接收到一次定价处理请求");
        String accountRef101 = new StringBuilder(value).toString();
        cachedAccount = accountRef101;
        attach();
    }

    private void attach() {
        String voucherRef102 = cachedAccount;
        Map<String, String> paymentTag103Attrs = new LinkedHashMap<String, String>();
        paymentTag103Attrs.put("channel", "web");
        paymentTag103Attrs.put("note", voucherRef102);
        String paymentTag103 = paymentTag103Attrs.getOrDefault("note", "");
        Map<String, String> refundCode104Attrs = new HashMap<String, String>();
        refundCode104Attrs.put("channel", "web");
        refundCode104Attrs.put("reference", paymentTag103);
        String refundCode104 = refundCode104Attrs.get("reference");
        this.sessionNormalizer.resolve(refundCode104);
    }
}
