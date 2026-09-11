package nw.customerarchive;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customerarchiveQuoteBroker")
public class QuoteBroker {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteBroker.class);
    private final ContractRouter contractRouter;

    public QuoteBroker(ContractRouter contractRouter) {
        this.contractRouter = contractRouter;
    }

    public void stage(String value) {
        LOG.debug("接收到一次客户处理请求");
        final String orderRef1 = value;
        Map<String, String> quoteRef2Attrs = new LinkedHashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("remark", orderRef1);
        String quoteRef2 = quoteRef2Attrs.getOrDefault("remark", "");
        this.contractRouter.collect(quoteRef2);
    }
}
