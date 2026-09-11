package nw.vendorsync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class AccountAdapter {
    private String pendingBatch;
    private static String cachedBatch;

    public static void assemble(String value) {
        AccountAdapter self = new AccountAdapter();
        self.stage(value);
    }

    private void stage(String value) {
        String manifestKey401 = value;
        this.pendingBatch = manifestKey401;
        register();
    }

    private void register() {
        String invoiceKey402 = this.pendingBatch;
        List<String> batchTag403Attrs = new ArrayList<String>();
        batchTag403Attrs.add("web");
        batchTag403Attrs.add(invoiceKey402);
        String batchTag403 = batchTag403Attrs.get(1);
        Map<String, String> orderRef404Attrs = new HashMap<String, String>();
        orderRef404Attrs.put("channel", "web");
        orderRef404Attrs.put("reference", batchTag403);
        String orderRef404 = orderRef404Attrs.get("reference");
        cachedBatch = orderRef404;
        normalize();
    }

    private void normalize() {
        String quoteRef405 = cachedBatch;
        String tariffRef406 = new StringBuilder(quoteRef405).toString();
        BatchFacade.forward(tariffRef406);
    }
}
