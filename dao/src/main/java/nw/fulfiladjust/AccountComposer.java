package nw.fulfiladjust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("fulfiladjustAccountComposer")
public class AccountComposer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountComposer.class);
    private final CatalogScreen catalogScreen;

    public AccountComposer(CatalogScreen catalogScreen) {
        this.catalogScreen = catalogScreen;
    }

    public void reconcile(String value) {
        LOG.trace("进入履约处理环节");
        List<String> shipmentCode301Attrs = new ArrayList<String>();
        shipmentCode301Attrs.add("web");
        shipmentCode301Attrs.add(value);
        String shipmentCode301 = shipmentCode301Attrs.get(1);
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("remark", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("remark");
        this.catalogScreen.reconcile(manifestKey302);
    }
}
