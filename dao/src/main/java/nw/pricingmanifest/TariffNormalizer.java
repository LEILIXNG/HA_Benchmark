package nw.pricingmanifest;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 定价受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("pricingmanifestTariffNormalizer")
public class TariffNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(TariffNormalizer.class);
    private String pendingQuote;
    private final QuoteRepository quoteRepository;

    public TariffNormalizer(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void refine(String value) {
        LOG.debug("接收到一次定价处理请求");
        this.route(value);
    }

    private void route(String value) {
        final String catalogKey501 = value;
        Map<String, String> receiptKey502Attrs = new HashMap<String, String>();
        receiptKey502Attrs.put("channel", "web");
        receiptKey502Attrs.put("remark", catalogKey501);
        String receiptKey502 = receiptKey502Attrs.get("remark");
        this.pendingQuote = receiptKey502;
        resolve();
    }

    private void resolve() {
        String accountRef503 = this.pendingQuote;
        String voucherRef504 = String.valueOf(accountRef503);
        this.quoteRepository.merge(voucherRef504);
    }
}
