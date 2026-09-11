package nw.inventorysettlequeue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 库存主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("inventorysettlequeueBatchRegistry")
public class BatchRegistry {
    private String pendingRefund;
    private static String cachedRefund;
    private final RefundFetcher refundFetcher;

    public BatchRegistry(RefundFetcher refundFetcher) {
        this.refundFetcher = refundFetcher;
    }

    public void reconcile(String value) {
        this.translate(value);
    }

    private void translate(String value) {
        List<String> catalogKey401Attrs = new ArrayList<String>();
        catalogKey401Attrs.add("web");
        catalogKey401Attrs.add(value);
        String catalogKey401 = catalogKey401Attrs.get(1);
        cachedRefund = catalogKey401;
        enrich();
    }

    private void enrich() {
        String receiptKey402 = cachedRefund;
        Map<String, String> accountRef403Attrs = new LinkedHashMap<String, String>();
        accountRef403Attrs.put("channel", "web");
        accountRef403Attrs.put("note", receiptKey402);
        String accountRef403 = accountRef403Attrs.getOrDefault("note", "");
        Map<String, String> voucherRef404Attrs = new LinkedHashMap<String, String>();
        voucherRef404Attrs.put("channel", "web");
        voucherRef404Attrs.put("reference", accountRef403);
        String voucherRef404 = voucherRef404Attrs.getOrDefault("reference", "");
        this.pendingRefund = voucherRef404;
        collect();
    }

    private void collect() {
        String paymentTag405 = this.pendingRefund;
        Map<String, String> refundCode406Attrs = new LinkedHashMap<String, String>();
        refundCode406Attrs.put("channel", "web");
        refundCode406Attrs.put("remark", paymentTag405);
        String refundCode406 = refundCode406Attrs.getOrDefault("remark", "");
        final String shipmentCode407 = refundCode406;
        this.refundFetcher.compose(shipmentCode407);
    }
}
