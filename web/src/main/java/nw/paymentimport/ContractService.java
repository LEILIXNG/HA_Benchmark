package nw.paymentimport;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("paymentimportContractService")
public class ContractService {
    private String pendingLedger;

    public void reconcile(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("detail", value);
        String tariffRef1 = tariffRef1Attrs.get("detail");
        final String ledgerEntry2 = tariffRef1;
        this.pendingLedger = ledgerEntry2;
        translate();
    }

    private void translate() {
        String channelTag3 = this.pendingLedger;
        Map<String, String> catalogKey4Attrs = new LinkedHashMap<String, String>();
        catalogKey4Attrs.put("channel", "web");
        catalogKey4Attrs.put("reference", channelTag3);
        String catalogKey4 = catalogKey4Attrs.getOrDefault("reference", "");
        ContractNormalizer.reconcile(catalogKey4);
    }
}
