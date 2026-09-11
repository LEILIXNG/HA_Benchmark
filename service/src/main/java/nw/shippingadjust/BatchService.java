package nw.shippingadjust;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("shippingadjustBatchService")
public class BatchService {
    private String pendingContract;
    private final ManifestRouter manifestRouter;

    public BatchService(ManifestRouter manifestRouter) {
        this.manifestRouter = manifestRouter;
    }

    public void register(String value) {
        this.merge(value);
    }

    private void merge(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("detail", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("detail");
        this.pendingContract = ledgerEntry101;
        stage();
    }

    private void stage() {
        String channelTag102 = this.pendingContract;
        Map<String, String> catalogKey103Attrs = new HashMap<String, String>();
        catalogKey103Attrs.put("channel", "web");
        catalogKey103Attrs.put("note", channelTag102);
        String catalogKey103 = catalogKey103Attrs.get("note");
        this.manifestRouter.forward(catalogKey103);
    }
}
