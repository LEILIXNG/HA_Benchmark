package nw.accountrefund;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("accountrefundBatchResolver")
public class BatchResolver {
    private static final Logger LOG = LoggerFactory.getLogger(BatchResolver.class);
    private String pendingVoucher;
    private static String cachedVoucher;
    private final ChannelAdapter channelAdapter;

    public BatchResolver(ChannelAdapter channelAdapter) {
        this.channelAdapter = channelAdapter;
    }

    public void compose(String value) {
        LOG.debug("开始整理账户字段");
        this.refine(value);
    }

    private void refine(String value) {
        final String quoteRef1 = value;
        Map<String, String> tariffRef2Attrs = new LinkedHashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("remark", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.getOrDefault("remark", "");
        cachedVoucher = tariffRef2;
        route();
    }

    private void route() {
        String ledgerEntry3 = cachedVoucher;
        String channelTag4 = String.valueOf(ledgerEntry3);
        this.pendingVoucher = channelTag4;
        normalize();
    }

    private void normalize() {
        String catalogKey5 = this.pendingVoucher;
        String receiptKey6 = String.valueOf(catalogKey5);
        cachedVoucher = receiptKey6;
        collect();
    }

    private void collect() {
        String accountRef7 = cachedVoucher;
        final String voucherRef8 = accountRef7;
        this.pendingVoucher = voucherRef8;
        register();
    }

    private void register() {
        String paymentTag9 = this.pendingVoucher;
        String refundCode10 = new StringBuilder(paymentTag9).toString();
        this.pendingVoucher = refundCode10;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode11 = this.pendingVoucher;
        String manifestKey12 = new StringBuilder(shipmentCode11).toString();
        String invoiceKey13 = "ref_" + manifestKey12;
        this.channelAdapter.stage(invoiceKey13);
    }
}
