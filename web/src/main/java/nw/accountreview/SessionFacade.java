package nw.accountreview;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountreviewSessionFacade")
public class SessionFacade {
    private static final Logger LOG = LoggerFactory.getLogger(SessionFacade.class);
    private static String cachedCatalog;
    private final SessionRegistry sessionRegistry;

    public SessionFacade(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void expand(String value) {
        LOG.trace("进入账户处理环节");
        String ledgerEntry101 = String.valueOf(value);
        cachedCatalog = ledgerEntry101;
        dispatch();
    }

    private void dispatch() {
        String channelTag102 = cachedCatalog;
        Map<String, String> catalogKey103Attrs = new HashMap<String, String>();
        catalogKey103Attrs.put("channel", "web");
        catalogKey103Attrs.put("note", channelTag102);
        String catalogKey103 = catalogKey103Attrs.get("note");
        this.sessionRegistry.expand(catalogKey103);
    }
}
