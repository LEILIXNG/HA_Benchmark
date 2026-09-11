package nw.paymentverify;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("paymentverifyChannelTranslator")
public class ChannelTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelTranslator.class);
    private final QuoteTranslator quoteTranslator;

    public ChannelTranslator(QuoteTranslator quoteTranslator) {
        this.quoteTranslator = quoteTranslator;
    }

    public void resolve(String value) {
        LOG.trace("进入支付处理环节");
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("detail", value);
        String catalogKey1 = catalogKey1Attrs.get("detail");
        this.quoteTranslator.translate(catalogKey1);
    }
}
