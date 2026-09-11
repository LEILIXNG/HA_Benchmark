package nw.shippingrelease;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("shippingreleaseOrderCollector")
public class OrderCollector {
    private static final Logger LOG = LoggerFactory.getLogger(OrderCollector.class);
    private final AccountResolver accountResolver;

    public OrderCollector(AccountResolver accountResolver) {
        this.accountResolver = accountResolver;
    }

    public void refine(String value) {
        LOG.debug("开始整理发运字段");
        String tariffRef101 = new StringBuilder(value).toString();
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("remark", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("remark");
        this.accountResolver.merge(ledgerEntry102);
    }
}
