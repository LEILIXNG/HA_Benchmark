package nw.shippingtransfer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("shippingtransferCatalogCollector")
public class CatalogCollector {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogCollector.class);
    private String pendingContract;
    private final AccountPlanSelector accountPlanSelector;

    public CatalogCollector(AccountPlanSelector accountPlanSelector) {
        this.accountPlanSelector = accountPlanSelector;
    }

    public void attach(String value) {
        LOG.trace("进入发运处理环节");
        this.route(value);
    }

    private void route(String value) {
        List<String> tariffRef1Attrs = new ArrayList<String>();
        tariffRef1Attrs.add("web");
        tariffRef1Attrs.add(value);
        String tariffRef1 = tariffRef1Attrs.get(1);
        this.pendingContract = tariffRef1;
        translate();
    }

    private void translate() {
        String ledgerEntry2 = this.pendingContract;
        final String channelTag3 = ledgerEntry2;
        Map<String, String> catalogKey4Attrs = new LinkedHashMap<String, String>();
        catalogKey4Attrs.put("channel", "web");
        catalogKey4Attrs.put("reference", channelTag3);
        String catalogKey4 = catalogKey4Attrs.getOrDefault("reference", "");
        this.pendingContract = catalogKey4;
        forward();
    }

    private void forward() {
        String receiptKey5 = this.pendingContract;
        Map<String, String> accountRef6Attrs = new LinkedHashMap<String, String>();
        accountRef6Attrs.put("channel", "web");
        accountRef6Attrs.put("remark", receiptKey5);
        String accountRef6 = accountRef6Attrs.getOrDefault("remark", "");
        String voucherRef7 = accountRef6;
        this.accountPlanSelector.attach(voucherRef7);
    }
}
