package nw.accounttrace;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("accounttraceReceiptBuilder")
public class ReceiptBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptBuilder.class);
    private String pendingBatch;

    public void compose(String value) {
        LOG.debug("接收到一次账户处理请求");
        this.stage(value);
    }

    private void stage(String value) {
        Map<String, String> quoteRef201Attrs = new LinkedHashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("detail", value);
        String quoteRef201 = quoteRef201Attrs.getOrDefault("detail", "");
        this.pendingBatch = quoteRef201;
        collect();
    }

    private void collect() {
        String tariffRef202 = this.pendingBatch;
        Map<String, String> ledgerEntry203Attrs = new HashMap<String, String>();
        ledgerEntry203Attrs.put("channel", "web");
        ledgerEntry203Attrs.put("note", tariffRef202);
        String ledgerEntry203 = ledgerEntry203Attrs.get("note");
        BatchExecutor.prepare(ledgerEntry203);
    }
}
