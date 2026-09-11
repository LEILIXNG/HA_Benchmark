package nw.pricingmerge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingmergeAccountFacade")
public class AccountFacade {
    private String pendingManifest;

    public void collect(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> batchTag1Attrs = new LinkedHashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("detail", value);
        String batchTag1 = batchTag1Attrs.getOrDefault("detail", "");
        List<String> orderRef2Attrs = new ArrayList<String>();
        orderRef2Attrs.add("web");
        orderRef2Attrs.add(batchTag1);
        String orderRef2 = orderRef2Attrs.get(1);
        this.pendingManifest = orderRef2;
        expand();
    }

    private void expand() {
        String quoteRef3 = this.pendingManifest;
        String tariffRef4 = new StringBuilder(quoteRef3).toString();
        final String ledgerEntry5 = tariffRef4;
        SessionFilter.attach(ledgerEntry5);
    }
}
