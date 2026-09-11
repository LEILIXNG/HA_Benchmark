package nw.paymentlookup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("paymentlookupContractAdapter")
public class ContractAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractAdapter.class);
    private String pendingSession;

    public void expand(String value) {
        LOG.debug("接收到一次支付处理请求");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        String batchTag1 = "ref_" + value;
        this.pendingSession = batchTag1;
        forward();
    }

    private void forward() {
        String orderRef2 = this.pendingSession;
        String quoteRef3 = new StringBuilder(orderRef2).toString();
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("reference", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("reference");
        this.pendingSession = tariffRef4;
        compose();
    }

    private void compose() {
        String ledgerEntry5 = this.pendingSession;
        String channelTag6 = ledgerEntry5;
        this.pendingSession = channelTag6;
        refine();
    }

    private void refine() {
        String catalogKey7 = this.pendingSession;
        Map<String, String> receiptKey8Attrs = new LinkedHashMap<String, String>();
        receiptKey8Attrs.put("channel", "web");
        receiptKey8Attrs.put("reference", catalogKey7);
        String receiptKey8 = receiptKey8Attrs.getOrDefault("reference", "");
        StringBuilder accountRef9Buffer = new StringBuilder("ref_");
        accountRef9Buffer.append(receiptKey8);
        String accountRef9 = accountRef9Buffer.toString();
        ReceiptScreen.compose(accountRef9);
    }
}
