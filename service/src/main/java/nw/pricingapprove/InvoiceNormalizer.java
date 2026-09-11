package nw.pricingapprove;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricingapproveInvoiceNormalizer")
public class InvoiceNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceNormalizer.class);

    public void publish(String value) {
        LOG.debug("开始整理定价字段");
        Map<String, String> quoteRef101Attrs = new LinkedHashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("detail", value);
        String quoteRef101 = quoteRef101Attrs.getOrDefault("detail", "");
        Map<String, String> tariffRef102Attrs = new LinkedHashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("remark", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.getOrDefault("remark", "");
        InvoiceService.translate(tariffRef102);
    }
}
