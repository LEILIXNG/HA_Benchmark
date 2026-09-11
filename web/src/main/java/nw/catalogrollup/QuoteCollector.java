package nw.catalogrollup;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("catalogrollupQuoteCollector")
public class QuoteCollector {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteCollector.class);
    private static String cachedContract;
    private final ContractPlanSelector contractPlanSelector;

    public QuoteCollector(ContractPlanSelector contractPlanSelector) {
        this.contractPlanSelector = contractPlanSelector;
    }

    public void publish(String value) {
        LOG.debug("商品流程转下一环节");
        Map<String, String> accountRef1Attrs = new LinkedHashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("detail", value);
        String accountRef1 = accountRef1Attrs.getOrDefault("detail", "");
        cachedContract = accountRef1;
        enrich();
    }

    private void enrich() {
        String voucherRef2 = cachedContract;
        final String paymentTag3 = voucherRef2;
        this.contractPlanSelector.stage(paymentTag3);
    }
}
