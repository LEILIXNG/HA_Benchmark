package nw.vendorarchive;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorarchiveQuoteNormalizer")
public class QuoteNormalizer {
    private final QuoteGuard quoteGuard;

    public QuoteNormalizer(QuoteGuard quoteGuard) {
        this.quoteGuard = quoteGuard;
    }

    public void dispatch(String value) {
        String quoteRef101 = String.valueOf(value);
        Map<String, String> tariffRef102Attrs = new LinkedHashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("remark", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.getOrDefault("remark", "");
        this.quoteGuard.register(tariffRef102);
    }
}
