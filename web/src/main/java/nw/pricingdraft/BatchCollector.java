package nw.pricingdraft;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingdraftBatchCollector")
public class BatchCollector {
    private final SessionAdapter sessionAdapter;

    public BatchCollector(SessionAdapter sessionAdapter) {
        this.sessionAdapter = sessionAdapter;
    }

    public void reconcile(String value) {
        String manifestKey101 = new StringBuilder(value).toString();
        Map<String, String> invoiceKey102Attrs = new LinkedHashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("remark", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.getOrDefault("remark", "");
        this.sessionAdapter.dispatch(invoiceKey102);
    }
}
