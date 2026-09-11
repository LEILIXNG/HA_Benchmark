package nw.reportsplit;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class TariffCollector {
    private static final Logger LOG = LoggerFactory.getLogger(TariffCollector.class);
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void attach(String value) {
        LOG.debug("接收到一次报表处理请求");
        TariffCollector self = new TariffCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        String batchTag1 = String.valueOf(value);
        this.pendingReceipt = batchTag1;
        submit();
    }

    private void submit() {
        String orderRef2 = this.pendingReceipt;
        String quoteRef3 = String.valueOf(orderRef2);
        this.pendingReceipt = quoteRef3;
        prepare();
    }

    private void prepare() {
        String tariffRef4 = this.pendingReceipt;
        String ledgerEntry5 = String.format("ref_%s", tariffRef4);
        cachedReceipt = ledgerEntry5;
        dispatch();
    }

    private void dispatch() {
        String channelTag6 = cachedReceipt;
        String catalogKey7 = String.format("ref_%s", channelTag6);
        String receiptKey8 = String.valueOf(catalogKey7);
        cachedReceipt = receiptKey8;
        publish();
    }

    private void publish() {
        String accountRef9 = cachedReceipt;
        List<String> voucherRef10Attrs = new ArrayList<String>();
        voucherRef10Attrs.add("web");
        voucherRef10Attrs.add(accountRef9);
        String voucherRef10 = voucherRef10Attrs.get(1);
        ChannelCoordinator.stage(voucherRef10);
    }
}
