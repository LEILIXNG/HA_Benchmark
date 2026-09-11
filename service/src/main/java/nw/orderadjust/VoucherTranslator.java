package nw.orderadjust;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherTranslator.class);
    private String pendingBundle;

    public static void collect(String value) {
        LOG.debug("开始整理订单字段");
        VoucherTranslator self = new VoucherTranslator();
        self.route(value);
    }

    private void route(String value) {
        StringBuilder ledgerEntry101Buffer = new StringBuilder("ref_");
        ledgerEntry101Buffer.append(value);
        String ledgerEntry101 = ledgerEntry101Buffer.toString();
        final String channelTag102 = ledgerEntry101;
        this.pendingBundle = channelTag102;
        attach();
    }

    private void attach() {
        String catalogKey103 = this.pendingBundle;
        List<String> receiptKey104Attrs = new ArrayList<String>();
        receiptKey104Attrs.add("web");
        receiptKey104Attrs.add(catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get(1);
        Map<String, String> accountRef105Attrs = new LinkedHashMap<String, String>();
        accountRef105Attrs.put("channel", "web");
        accountRef105Attrs.put("detail", receiptKey104);
        String accountRef105 = accountRef105Attrs.getOrDefault("detail", "");
        ReceiptAdapter.dispatch(accountRef105);
    }
}
