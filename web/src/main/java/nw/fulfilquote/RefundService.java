package nw.fulfilquote;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("fulfilquoteRefundService")
public class RefundService {
    private static final Logger LOG = LoggerFactory.getLogger(RefundService.class);

    public void attach(String value) {
        LOG.debug("接收到一次履约处理请求");
        String manifestKey1 = value;
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("remark", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("remark");
        ManifestValidator.assemble(invoiceKey2);
    }
}
