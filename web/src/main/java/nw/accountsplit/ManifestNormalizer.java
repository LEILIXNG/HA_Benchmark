package nw.accountsplit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("accountsplitManifestNormalizer")
public class ManifestNormalizer {
    private static String cachedShipment;
    private final BatchPolicySelector batchPolicySelector;

    public ManifestNormalizer(BatchPolicySelector batchPolicySelector) {
        this.batchPolicySelector = batchPolicySelector;
    }

    public void normalize(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("detail", value);
        String quoteRef1 = quoteRef1Attrs.get("detail");
        Map<String, String> tariffRef2Attrs = new LinkedHashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("remark", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.getOrDefault("remark", "");
        cachedShipment = tariffRef2;
        publish();
    }

    private void publish() {
        String ledgerEntry3 = cachedShipment;
        List<String> channelTag4Attrs = new ArrayList<String>();
        channelTag4Attrs.add("web");
        channelTag4Attrs.add(ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get(1);
        final String catalogKey5 = channelTag4;
        this.batchPolicySelector.dispatch(catalogKey5);
    }
}
