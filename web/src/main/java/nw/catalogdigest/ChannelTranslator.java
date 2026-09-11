package nw.catalogdigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ChannelTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelTranslator.class);
    private String pendingRefund;
    private static String cachedRefund;

    public static void forward(String value) {
        LOG.trace("进入商品处理环节");
        ChannelTranslator self = new ChannelTranslator();
        self.assemble(value);
    }

    private void assemble(String value) {
        final String orderRef1 = value;
        List<String> quoteRef2Attrs = new ArrayList<String>();
        quoteRef2Attrs.add("web");
        quoteRef2Attrs.add(orderRef1);
        String quoteRef2 = quoteRef2Attrs.get(1);
        cachedRefund = quoteRef2;
        merge();
    }

    private void merge() {
        String tariffRef3 = cachedRefund;
        String ledgerEntry4 = "ref_".concat(tariffRef3);
        List<String> channelTag5Attrs = new ArrayList<String>();
        channelTag5Attrs.add("web");
        channelTag5Attrs.add(ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get(1);
        cachedRefund = channelTag5;
        normalize();
    }

    private void normalize() {
        String catalogKey6 = cachedRefund;
        Map<String, String> receiptKey7Attrs = new LinkedHashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("note", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.getOrDefault("note", "");
        this.pendingRefund = receiptKey7;
        translate();
    }

    private void translate() {
        String accountRef8 = this.pendingRefund;
        StringBuilder voucherRef9Buffer = new StringBuilder("ref_");
        voucherRef9Buffer.append(accountRef8);
        String voucherRef9 = voucherRef9Buffer.toString();
        Map<String, String> paymentTag10Attrs = new HashMap<String, String>();
        paymentTag10Attrs.put("channel", "web");
        paymentTag10Attrs.put("remark", voucherRef9);
        String paymentTag10 = paymentTag10Attrs.get("remark");
        ManifestPolicySelector.submit(paymentTag10);
    }
}
