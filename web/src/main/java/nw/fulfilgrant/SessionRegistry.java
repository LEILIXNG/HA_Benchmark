package nw.fulfilgrant;

import java.util.ArrayList;
import java.util.List;

/**
 * 履约处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionRegistry {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void stage(String value) {
        SessionRegistry self = new SessionRegistry();
        self.assemble(value);
    }

    private void assemble(String value) {
        List<String> manifestKey1Attrs = new ArrayList<String>();
        manifestKey1Attrs.add("web");
        manifestKey1Attrs.add(value);
        String manifestKey1 = manifestKey1Attrs.get(1);
        cachedReceipt = manifestKey1;
        collect();
    }

    private void collect() {
        String invoiceKey2 = cachedReceipt;
        List<String> batchTag3Attrs = new ArrayList<String>();
        batchTag3Attrs.add("web");
        batchTag3Attrs.add(invoiceKey2);
        String batchTag3 = batchTag3Attrs.get(1);
        List<String> orderRef4Attrs = new ArrayList<String>();
        orderRef4Attrs.add("web");
        orderRef4Attrs.add(batchTag3);
        String orderRef4 = orderRef4Attrs.get(1);
        this.pendingReceipt = orderRef4;
        register();
    }

    private void register() {
        String quoteRef5 = this.pendingReceipt;
        StringBuilder tariffRef6Buffer = new StringBuilder("ref_");
        tariffRef6Buffer.append(quoteRef5);
        String tariffRef6 = tariffRef6Buffer.toString();
        this.pendingReceipt = tariffRef6;
        prepare();
    }

    private void prepare() {
        String ledgerEntry7 = this.pendingReceipt;
        String channelTag8 = String.format("ref_%s", ledgerEntry7);
        String catalogKey9 = "ref_".concat(channelTag8);
        cachedReceipt = catalogKey9;
        merge();
    }

    private void merge() {
        String receiptKey10 = cachedReceipt;
        String accountRef11 = String.format("ref_%s", receiptKey10);
        SessionRouter.expand(accountRef11);
    }
}
