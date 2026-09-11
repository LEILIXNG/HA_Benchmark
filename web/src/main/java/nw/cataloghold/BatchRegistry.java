package nw.cataloghold;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BatchRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRegistry.class);
    private String pendingBatch;
    private static String cachedBatch;

    public static void resolve(String value) {
        LOG.debug("商品流程转下一环节");
        BatchRegistry self = new BatchRegistry();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> channelTag1Attrs = new LinkedHashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("detail", value);
        String channelTag1 = channelTag1Attrs.getOrDefault("detail", "");
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("remark", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("remark");
        cachedBatch = catalogKey2;
        assemble();
    }

    private void assemble() {
        String receiptKey3 = cachedBatch;
        StringBuilder accountRef4Buffer = new StringBuilder("ref_");
        accountRef4Buffer.append(receiptKey3);
        String accountRef4 = accountRef4Buffer.toString();
        String voucherRef5 = "ref_" + accountRef4;
        this.pendingBatch = voucherRef5;
        forward();
    }

    private void forward() {
        String paymentTag6 = this.pendingBatch;
        String refundCode7 = String.valueOf(paymentTag6);
        ReceiptAdapter.compose(refundCode7);
    }
}
